package com.example.evaluation.contoller;

import com.example.evaluation.dtos.ChangeEmailDTO;
import com.example.evaluation.dtos.ChangePasswordDTO;
import com.example.evaluation.dtos.UserDto;
import com.example.evaluation.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {
        return service.createUser(dto);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto dto) {
        return service.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteUser(id);
    }


    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/{userId}/change_email")
    public ResponseEntity<String> changeEmail(@PathVariable Long userId, @Validated @RequestBody ChangeEmailDTO changeEmailDTO) throws Exception {
        return new ResponseEntity<>(service.changeEmail(changeEmailDTO, userId), HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/{userId}/change_password")
    public ResponseEntity changePassword(@PathVariable Long userId, @Validated @RequestBody ChangePasswordDTO changePasswordDTO) throws Exception {
        service.changePassword(changePasswordDTO, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
