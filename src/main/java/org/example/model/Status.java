package org.example.model;

public enum Status {
    ENABLED("Enabled"), DISABLED("Disabled");
    public final String status;
    Status(String status) {
        this.status = status;
    }
}
