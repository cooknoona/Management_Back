package com.product.management.repository;

import com.product.management.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Employees, Long> {
    boolean existsByEmail(String value);

    boolean existsByPhone(String value);

    Optional<Employees> findByEmployeeCode(String employeeCode);
}
