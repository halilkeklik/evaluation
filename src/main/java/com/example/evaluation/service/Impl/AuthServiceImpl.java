package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.LoginRequestDTO;
import com.example.evaluation.dtos.RegisterRequestDTO;
import com.example.evaluation.models.User;
import com.example.evaluation.repository.UserRepository;
import com.example.evaluation.security.jwt.JwtUtil;
import com.example.evaluation.security.user.UserRole;
import com.example.evaluation.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository,
                           AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(RegisterRequestDTO request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.ROLE_USER)
                .build();

        user = userRepository.save(user);

        userRepository.save(user);
    }

    @Override
    public Map<String, String> login(LoginRequestDTO request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        String token = jwtUtil.generateToken(auth);
        return Map.of("token_type", "Bearer", "token", token);
    }
}