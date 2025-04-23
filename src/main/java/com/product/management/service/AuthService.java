package com.product.management.service;

import com.product.management.dto.request.EmployeeRequest;
import com.product.management.entity.Employees;
import com.product.management.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Boolean validationCheck(String key, String value) {
        return switch (key) {
            case "email":
                if (userRepository.existsByEmail(value)) {
                    throw new DuplicateKeyException("Email is already used!");
                }
                yield true;
            case "phone":
                if (userRepository.existsByPhone(value)) {
                    throw new DuplicateKeyException("Phone number is already used!");
                }
                yield true;
            default:
                throw new EntityNotFoundException("Invalid Key!");
        };
    }

    public Boolean registration(EmployeeRequest userRequest) {
        Employees employees = userRequest.toJoin(passwordEncoder);
        userRepository.save(employees);
        return true;
    }
}
