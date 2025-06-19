package com.profile.profile_service.controller;

import java.util.List;

import com.profile.profile_service.dto.request.ApiResponse;
import org.springframework.web.bind.annotation.*;

import com.profile.profile_service.dto.request.ProfileUpdateRequest;
import com.profile.profile_service.dto.response.ProfileCreationResponse;
import com.profile.profile_service.entity.UserProfile;
import com.profile.profile_service.service.UserProfileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileController {
    UserProfileService userProfileService;

    @GetMapping("/users/{profileId}")
    public ProfileCreationResponse getProfile(@PathVariable String profileId) {
        return userProfileService.getOneUserProfile(profileId);
    }

    @GetMapping("/users")
    public List<UserProfile> getProfile() {
        return userProfileService.getAllUserProfile();
    }

    @PutMapping("/users/my-profile")
    public ApiResponse<ProfileCreationResponse> updateProfile(@RequestBody ProfileUpdateRequest profileUpdateRequest){
        return ApiResponse.<ProfileCreationResponse>builder()
                .result(userProfileService.updateUserProfile(profileUpdateRequest))
                .build();
    }
}
