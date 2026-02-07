package com.book.hdn.controller.auth;

import com.book.hdn.entity.User;
import com.book.hdn.repository.UserRepository;
import com.book.hdn.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        repo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User req) {
        User user = repo.findByUsername(req.getUsername()).orElseThrow();
        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }
}

