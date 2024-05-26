package com.backend.gg.security.service.Impl;

import com.backend.gg.security.dto.UserRequestDtoUpdate;
import com.backend.gg.security.dto.UserResponseDto;
import com.backend.gg.security.exception.ResourceNotFoundException;
import com.backend.gg.security.mapper.UserMapper;
import com.backend.gg.security.repository.UserRepository;
import com.backend.gg.security.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public List<UserResponseDto> getAll() {
        return userMapper.convertToListDto(userRepository.findAll());
    }

    @Override
    public Optional<UserResponseDto> getUser(Long idUser) {
        return Optional.of(userMapper.toUserDto(userRepository.getUserById(idUser)));
    }

    @Override
    public UserResponseDto update(UserRequestDtoUpdate userDtoUpdate) {

        if(userRepository.findByEmail(userDtoUpdate.getEmail()).isEmpty()){
            throw new ResourceNotFoundException("El correo electrónico no se encuentra registrado");
        }

        var user = userRepository.getUserById(userDtoUpdate.getId());
        BeanUtils.copyProperties(userDtoUpdate, user);

        return userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public boolean delete(Long idUser) {
        if(userRepository.getUserById(idUser) != null){
            return false;
        }
        userRepository.deleteById(idUser);
        return true;
    }
}
