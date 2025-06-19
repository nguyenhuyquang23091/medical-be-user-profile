package com.profile.profile_service.repository.http_client;


import com.profile.profile_service.config.AuthenticationInterceptor;
import com.profile.profile_service.dto.request.ApiResponse;
import com.profile.profile_service.dto.request.ProfileUpdateRequest;
import com.profile.profile_service.dto.response.ProfileCreationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", url = "${spring.app.services.auth}",
        configuration = {AuthenticationInterceptor.class})
public interface AuthClient {
    //this OpenFeign fetch external data and function as data source for service
    //the same operation with other repository so it should be placed it repository package
        @PostMapping(value = "/users/my-info", produces = MediaType.APPLICATION_JSON_VALUE)
        ApiResponse<ProfileCreationResponse> createProfile
        (@RequestBody ProfileUpdateRequest request);




}
