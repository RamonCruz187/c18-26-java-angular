package com.backend.gg.security.service;

import com.backend.gg.security.dto.UserRequestDtoUpdate;
import com.backend.gg.security.dto.UserResponseDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserResponseDto> getAll();
    Optional<UserResponseDto> getUser(Long idUser);
    UserResponseDto update(UserRequestDtoUpdate userDtoUpdate);
    boolean delete(Long idUser);
}
