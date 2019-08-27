package com.registration.employeeportal.service;

public enum ResponseMapKey {
    DATA,
    ERRORS;

    public String literal() {
        return name().toLowerCase();
    }
}
