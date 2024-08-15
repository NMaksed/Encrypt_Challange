package com.grecco.encryption.model.dtos;

import lombok.Data;

@Data
public class UserDto {

    private String userDocument;
    private String creditCardToken;
    private Long value;
}
