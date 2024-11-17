package com.timesaverq.timesaverq.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueueRequest {
    private String serviceId;
    private String userId;
}
