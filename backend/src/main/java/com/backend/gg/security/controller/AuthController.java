package com.backend.gg.security.controller;

import com.backend.gg.security.dto.AuthResponseDto;
import com.backend.gg.security.dto.LoginRequestDto;
import com.backend.gg.security.dto.RegisterRequestDto;
import com.backend.gg.security.service.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final IAuthService authService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDto login){

        AuthResponseDto response = authService.login(login);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDto newUserDto){

        AuthResponseDto response = authService.register(newUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}