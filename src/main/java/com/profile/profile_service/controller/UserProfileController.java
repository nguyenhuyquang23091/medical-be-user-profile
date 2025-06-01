package com.profile.profile_service.controller;


import com.profile.profile_service.dto.request.ProfileCreationRequest;
import com.profile.profile_service.dto.response.ProfileCreationResponse;
import com.profile.profile_service.entity.UserProfile;
import com.profile.profile_service.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level =  AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileController {
    UserProfileService userProfileService;
    @PostMapping("/user")
    public ProfileCreationResponse creationProfile(@RequestBody ProfileCreationRequest request){
        return userProfileService.createUserProfile(request);
    }
    @GetMapping("/{profileId}")
    public ProfileCreationResponse getProfile( @PathVariable  String profileId){
        return userProfileService.getOneUserProfile(profileId);
    }
    @GetMapping()
    public List<UserProfile> getProfile(){
        return userProfileService.getAllUserProfile();
    }

}
