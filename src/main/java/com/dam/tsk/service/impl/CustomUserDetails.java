package com.dam.tsk.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import com.dam.tsk.entity.UserInfo;
import com.dam.tsk.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails{
    private UserInfo user;
    public CustomUserDetails(UserInfo user) {

        this.user=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

       return user.getRoles().stream().map(roles->new SimpleGrantedAuthority(roles.getRoleName()))
               .collect(Collectors.toList());
      }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}
