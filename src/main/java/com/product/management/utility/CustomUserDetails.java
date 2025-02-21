package com.product.management.utility;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

// Record class for authenticate object from CustomUserDetailsService
public record CustomUserDetails(
        Long id,
        String employeeCode,
        String name,
        String password,
        Collection<? extends GrantedAuthority> authorities
) implements UserDetails {

    @Override
    public String getUsername() {
        return employeeCode;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

