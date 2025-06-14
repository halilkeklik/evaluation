package com.example.evaluation.service;

import com.example.evaluation.security.jwt.JwtUtil;
import com.example.evaluation.security.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentUser {
    private static String TOKEN;

    @Autowired
    private JwtUtil jwtUtil;

    public static void setToken(String token) {
        TOKEN = token;
    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser");
    }

    public Long getUserId() throws Exception {
        if (TOKEN == null) throw new Exception();
        return jwtUtil.getUserIdFromToken(TOKEN);
    }

    public Long getProfileId() throws Exception {
        if (TOKEN == null) throw new Exception();
        return jwtUtil.getClaimFromToken(TOKEN, claims -> claims.get("profileId", Long.class));
    }

    public boolean hasRole(UserRole role) throws Exception {
        if (TOKEN == null) throw new Exception();
        List<GrantedAuthority> authorities = jwtUtil.getGrantedAuthorities(TOKEN);
        return authorities.stream().anyMatch(a -> a.getAuthority().equals(role.toString()));
    }
}