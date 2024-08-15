package com.grecco.encryption.service;

import com.grecco.encryption.service.exceptions.ExceptionFactory;
import lombok.RequiredArgsConstructor;
import com.grecco.encryption.model.User;
import com.grecco.encryption.model.dtos.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.grecco.encryption.repository.UserRepository;
import com.grecco.encryption.service.interfaces.UserServiceInterface;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final EncryptService encryptService;

    @Transactional(readOnly = true)
    public List<User> getAllUsersDecripted() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            String decryptedDocument = encryptService.decryptString(user.getUserDocument());
            String decryptedToken = encryptService.decryptString(user.getCreditCardToken());

            user.setUserDocument(decryptedDocument);
            user.setCreditCardToken(decryptedToken);
        }
        return users;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> ExceptionFactory.userNotFound(id));

        String decryptedDocument = encryptService.decryptString(user.getUserDocument());
        String decryptedToken = encryptService.decryptString(user.getCreditCardToken());

        user.setUserDocument(decryptedDocument);
        user.setCreditCardToken(decryptedToken);
        return user;
    }

    @Transactional
    public void saveUser(UserDto dto) {
        userRepository.save(buildUserFromDto(new User(), dto));
    }

    @Transactional
    public void updateUser(UserDto dto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> ExceptionFactory.userNotFound(id));
        userRepository.save(buildUserFromDto(user, dto));
    }

    @Transactional
    public void deleteUser(Long id) {
        if (userRepository.existsById(id))
            userRepository.deleteById(id);
        else
            throw ExceptionFactory.userDeleteError("Usuario não existe!");
    }

    public User buildUserFromDto(User user, UserDto dto) {
        if (dto.getUserDocument() != null) {
            String encryptedText = encryptService.encryptString(dto.getUserDocument());
            user.setUserDocument(encryptedText);
        }
        if (dto.getCreditCardToken() != null) {
            String encryptedText = encryptService.encryptString(dto.getCreditCardToken());
            user.setCreditCardToken(encryptedText);
        }
        if (dto.getValue() != null)
            user.setValue(dto.getValue());
        return user;
    }
}
