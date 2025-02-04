package com.dam.tsk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dam.tsk.dto.UserDTO;
import com.dam.tsk.entity.UserInfo;
import com.dam.tsk.repository.SBUserRepository;
import lombok.*;


@Service
public class SBUserService implements UserDetailsService {
	
	public SBUserService(SBUserRepository sbUserRepository) {
        this.sbUserRepository = sbUserRepository;
    }

	
   
    private SBUserRepository sbUserRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 UserInfo user = sbUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return new CustomUserDetails(user);
	}
}
