package com.profile.profile_service.service;

import java.util.List;

import com.profile.profile_service.exceptions.AppException;
import com.profile.profile_service.exceptions.ErrorCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.profile.profile_service.dto.request.ProfileCreationRequest;
import com.profile.profile_service.dto.request.ProfileUpdateRequest;
import com.profile.profile_service.dto.response.ProfileCreationResponse;
import com.profile.profile_service.entity.UserProfile;
import com.profile.profile_service.mapper.UserProfileMapper;
import com.profile.profile_service.repository.UserProfileRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;
    public ProfileCreationResponse createUserProfile(ProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile = userProfileRepository.save(userProfile);
        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    public ProfileCreationResponse updateUserProfile(ProfileUpdateRequest request) {

            var authentication = SecurityContextHolder.getContext().getAuthentication();
            String userId = authentication.getName();
            log.info("Userid is {}",userId);

            var userProfile =
                    userProfileRepository.findByUserId(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
            userProfileMapper.updateProfile(userProfile, request);
            return userProfileMapper.toUserProfileResponse(userProfileRepository.save(userProfile));

    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserProfile> getAllUserProfile() {
        return userProfileRepository.findAll();
    }

    public ProfileCreationResponse getOneUserProfile(String id) {
        UserProfile userProfile =
                userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find profile"));
        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    public void deleteProfile(String id) {
        userProfileRepository.deleteById(id);
    }
}
