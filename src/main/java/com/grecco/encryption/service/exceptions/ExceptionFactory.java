package com.grecco.encryption.service.exceptions;

public class ExceptionFactory {

    public static UserNotFoundException userNotFound(Long id){
        String message = String.format("Usuario de id %d não encontrado", id);
        return new UserNotFoundException(message);
    }

    public static UserSaveError userSaveError(String motivo){
        String message = String.format("Erro ao salvar: %s", motivo);
        return new UserSaveError(message);
    }

    public static UserDeleteError userDeleteError(String motivo){
        String message = String.format("Erro ao deletar: %s", motivo);
        return new UserDeleteError(message);
    }
}

