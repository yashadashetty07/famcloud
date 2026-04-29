package com.famcloud.controller;

import com.famcloud.dto.AuthResponse;
import com.famcloud.entity.User;
import com.famcloud.security.JwtUtil;
import com.famcloud.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final AuthService authService;

    @Autowired
    private final JwtUtil jwtUtil;

    @GetMapping("/success")
    public AuthResponse handleLogin(@AuthenticationPrincipal OAuth2User oauthUser) {

        if (oauthUser == null) {
            throw new RuntimeException("OAuth login failed or session missing");
        }

        Map<String, Object> attributes = oauthUser.getAttributes();
        String email = (String) attributes.get("email");

        User user = authService.processUser(email);

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

        return new AuthResponse(token);
    }

}
