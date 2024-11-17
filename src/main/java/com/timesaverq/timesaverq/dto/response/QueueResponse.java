package com.timesaverq.timesaverq.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueResponse {
    private String userName;
    private String userId;
    private String serviceName;
    private Integer queueNumber;
    private String queueStatus;
}
