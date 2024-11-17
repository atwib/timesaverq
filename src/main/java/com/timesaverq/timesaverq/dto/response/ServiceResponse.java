package com.timesaverq.timesaverq.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceResponse {
    private String name;
    private String description;
    private String startTime;
    private String endTime;
    private String isAvailable;
}
