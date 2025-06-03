package com.profile.profile_service.dto.response;

import java.time.LocalDate;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileCreationResponse {
    String id;
    String userId;
    String firstName;
    String lastName;
    String city;
    LocalDate dob;
}
