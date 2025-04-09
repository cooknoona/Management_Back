package com.product.management.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogInRequest {
    private String employeeCode;
    private String password;

    /**
     * To create an authenticate object to verify a user */
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(employeeCode, password);
    }
}
