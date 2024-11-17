package com.timesaverq.timesaverq.constant;

public enum UserRole {
    ROLE_ADMIN("Admin"),
    ROLE_USER("User");

    private final String description;
    UserRole(String description) {
        this.description = description;
    }

    public static UserRole findByDescription(String description) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.description.equals(description)) {
                return userRole;
            }
        }
        return null;
    }
}
