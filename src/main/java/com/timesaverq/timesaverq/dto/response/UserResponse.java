package com.timesaverq.timesaverq.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String username;
    private String name;
    private String phoneNumber;
    private String role;
}
