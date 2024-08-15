package com.grecco.encryption.service;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptService {
    private final StringEncryptor encryptor;

    @Autowired
    public EncryptService(StringEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    public String encryptString(String value) {
        return encryptor.encrypt(value);
    }

    public String decryptString(String value) {
        return encryptor.decrypt(value);
    }
}
