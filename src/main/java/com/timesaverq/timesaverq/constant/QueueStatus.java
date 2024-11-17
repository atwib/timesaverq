package com.timesaverq.timesaverq.constant;

public enum QueueStatus {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    COMPLETED("Completed"),
    CANCELED("Canceled");

    private final String description;
    QueueStatus(String description) {
        this.description = description;
    }

    public static QueueStatus findByDescription(String description) {
        for (QueueStatus queueStatus : QueueStatus.values()) {
            if (queueStatus.description.equals(description)) {
                return queueStatus;
            }
        }
        return null;
    }

}
