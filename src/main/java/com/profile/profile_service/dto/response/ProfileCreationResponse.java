package com.profile.profile_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileCreationResponse {
    String id;
    String firstName;
    String lastName;
    String city;
    LocalDate dob;
}
