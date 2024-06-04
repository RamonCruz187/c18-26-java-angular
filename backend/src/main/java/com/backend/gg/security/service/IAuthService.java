package com.backend.gg.security.service;

import com.backend.gg.security.dto.AuthResponseDto;
import com.backend.gg.security.dto.LoginRequestDto;
import com.backend.gg.security.dto.RegisterRequestDto;

public interface IAuthService {

    AuthResponseDto login(LoginRequestDto authRequest);

    AuthResponseDto register(RegisterRequestDto newUserDto);
}
