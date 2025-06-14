package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.ChangeEmailDTO;
import com.example.evaluation.dtos.ChangePasswordDTO;
import com.example.evaluation.dtos.UserDto;
import com.example.evaluation.mapper.UserMapper;
import com.example.evaluation.models.User;
import com.example.evaluation.repository.UserRepository;
import com.example.evaluation.service.CurrentUser;
import com.example.evaluation.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, UserMapper mapper, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto createUser(UserDto dto) {
        User entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        if (!repository.existsById(id)) return null;
        User entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDto getUserByName(String name) {
        User entity = repository.findByUsername(name).orElseThrow();
        return mapper.toDto(entity);
    }

    @Override
    public String changeEmail(ChangeEmailDTO changeEmailDTO, Long userId) throws Exception {
        if (!currentUser.getUserId().equals(userId)) throw new Exception();

        User user = repository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        user.setEmail(changeEmailDTO.getNewEmail());
        return repository.save(user).getEmail();
    }

    @Override
    public void changePassword(ChangePasswordDTO changePasswordDTO, Long userId) throws Exception {
        if (!currentUser.getUserId().equals(userId)) throw new Exception();

        User user = repository.findById(userId)
                .orElseThrow(Exception::new);

        if (!passwordEncoder.matches(changePasswordDTO.getCurrentPassword(), user.getPassword()))
            throw new CredentialException();

        user.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
        repository.save(user);
    }
}