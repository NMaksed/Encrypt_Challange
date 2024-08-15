package com.grecco.encryption.service.exceptions;

public class UserSaveError extends RuntimeException {
    public UserSaveError(String message) {
        super(message);
    }
}
