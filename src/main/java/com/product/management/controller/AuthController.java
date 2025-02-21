package com.product.management.controller;

import com.product.management.dto.request.UserRequest;
import com.product.management.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
public class AuthController {
    private final AuthService authService;

    // Controller for validation check
    @GetMapping("/validation")
    ResponseEntity<?> validation(@RequestParam String key, @RequestParam String value) {
        return ResponseEntity.ok(authService.validationCheck(key, value));
    }

    // Controller for user registration
    @PostMapping("/join")
    ResponseEntity<?> registration(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(authService.registration(userRequest));
    }
}
