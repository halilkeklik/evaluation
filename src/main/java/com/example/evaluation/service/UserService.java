package com.example.evaluation.service;

import com.example.evaluation.dtos.ChangeEmailDTO;
import com.example.evaluation.dtos.ChangePasswordDTO;
import com.example.evaluation.dtos.UserDto;

import javax.security.auth.login.CredentialException;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto dto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto updateUser(Long id, UserDto dto);

    void deleteUser(Long id);

    UserDto getUserByName(String name);

    String changeEmail(ChangeEmailDTO changeEmailDTO, Long userId) throws Exception;

    void changePassword(ChangePasswordDTO changePasswordDTO, Long userId) throws Exception;
}
