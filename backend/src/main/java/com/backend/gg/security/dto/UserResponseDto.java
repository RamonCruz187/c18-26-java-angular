package com.backend.gg.security.dto;

import com.backend.gg.entity.Order;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
