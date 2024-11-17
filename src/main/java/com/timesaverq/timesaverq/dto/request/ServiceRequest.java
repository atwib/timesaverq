package com.timesaverq.timesaverq.dto.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceRequest {
    private String name;
    private String description;
    private String startTime;
    private String endTime;
    private String isAvailable;
}
