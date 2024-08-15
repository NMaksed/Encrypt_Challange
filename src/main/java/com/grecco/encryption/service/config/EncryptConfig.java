package com.grecco.encryption.service.config;

import com.grecco.encryption.service.EncryptService;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptConfig {

    @Bean
    public EncryptService encryptService() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setPassword("grecco");
        return new EncryptService(encryptor);
    }
}
