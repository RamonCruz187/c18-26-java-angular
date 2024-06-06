package com.backend.gg.controller;

import com.backend.gg.dto.CartDto;
import com.backend.gg.repository.OrderDetailRepository;
import com.backend.gg.service.OrderDetailService;
import com.backend.gg.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class OrderDetailController {

    final OrderService orderService;
    final OrderDetailService orderDetailService;
    final OrderDetailRepository orderDetailRepository;

    @PostMapping("/{id}")
    public ResponseEntity<?> newCart (@RequestBody @Valid CartDto cartDto, @PathVariable Long id){
        try {
            if (orderDetailService.stockControl(cartDto)){
                orderDetailService.processNewCart(cartDto, id);
                return new ResponseEntity<>(HttpStatus.OK);

            }else {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Entity not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid argument: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}