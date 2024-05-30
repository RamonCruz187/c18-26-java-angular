package com.backend.gg.security.controller;

import com.backend.gg.security.dto.UserRequestDtoUpdate;
import com.backend.gg.security.dto.UserResponseDto;
import com.backend.gg.security.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(name = "/user")
public class UserController {

    private final IUserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());

        }catch (Exception e){
            List<UserResponseDto> list = new ArrayList<>();
            return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> UserById(@PathVariable Long id){

        try {
            Optional<UserResponseDto> userById = userService.getUser(id);
            return ResponseEntity.of(userById);
        }catch (Exception e){
            return new ResponseEntity<>("Error al encontrar el empleado", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserRequestDtoUpdate userDtoUpdate) {

        try {
            return ResponseEntity.ok(userService.update(userDtoUpdate));
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar el empleado", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.delete(id) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
