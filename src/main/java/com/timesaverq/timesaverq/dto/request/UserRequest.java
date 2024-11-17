package com.timesaverq.timesaverq.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String username;
    private String password;
    private String name;
    private String phoneNumber;
    private String role;
}
