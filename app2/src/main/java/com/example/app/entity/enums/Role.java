package com.example.app.entity.enums;

public enum Role {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String text;

    Role(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
