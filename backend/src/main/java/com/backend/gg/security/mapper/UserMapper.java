package com.backend.gg.security.mapper;

import com.backend.gg.security.dto.UserResponseDto;
import com.backend.gg.security.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public User toUserEntity(UserResponseDto userDto){

        return User.builder()
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .phone(userDto.getPhone())
                .address(userDto.getAddress())
                .email(userDto.getEmail())
                .build();
    }

    public UserResponseDto toUserDto(User userEntity){

        return UserResponseDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .lastName(userEntity.getLastName())
                .phone(userEntity.getPhone())
                .address(userEntity.getAddress())
                .email(userEntity.getEmail())
                .build();

    }

    public List<UserResponseDto> convertToListDto(List<User> users){

        if ( users == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<>();
        for ( User c : users ) {
            list.add(toUserDto(c));
        }

        return list;
    }
}
