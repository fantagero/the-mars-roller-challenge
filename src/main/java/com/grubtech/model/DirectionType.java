package com.grubtech.model;

public enum DirectionType {
    N("North"),
    S("South"),
    E("Est"),
    W("West");

    private final String description;

    DirectionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
