package com.product.management.service;

import com.product.management.entity.Employees;
import com.product.management.repository.UserRepository;
import com.product.management.utility.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String employeeCode) throws UsernameNotFoundException {
        Employees employees = userRepository.findByEmployeeCode(employeeCode)
                .orElseThrow(() -> new UsernameNotFoundException("Employee code not found"));
        return new CustomUserDetails(
                employees.getId(),
                employees.getEmployeeCode(),
                employees.getName(),
                employees.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(employees.getAuthority().toString()))
        );
    }
}
