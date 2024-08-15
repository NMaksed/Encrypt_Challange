package com.grecco.encryption.service.exceptions;

public class UserDeleteError extends RuntimeException {
    public UserDeleteError(String message) {
        super(message);
    }
}
