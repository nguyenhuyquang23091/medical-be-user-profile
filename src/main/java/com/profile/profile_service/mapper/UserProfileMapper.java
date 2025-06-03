package com.profile.profile_service.mapper;

import org.mapstruct.Mapper;

import com.profile.profile_service.dto.request.ProfileCreationRequest;
import com.profile.profile_service.dto.response.ProfileCreationResponse;
import com.profile.profile_service.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    UserProfile toUserProfile(ProfileCreationRequest request);

    ProfileCreationResponse toUserProfileResponse(UserProfile userProfile);
}
