package com.dam.tsk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dam.tsk.service.impl.SBUserService;

@Configuration
public class SpringConfig {


@Bean
public UserDetailsService userDetailsService(PasswordEncoder encoder) {
	UserDetails admin = User.withUsername("Basant")
			.password(encoder.encode("pwd1"))
			.roles("ADMIN")
			.build();
	
}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

      return  http.authorizeHttpRequests(req->
                req.requestMatchers("/home","/item").authenticated()
                        .requestMatchers("/registration","/user-login").permitAll()
        ).userDetailsService(sbUserService).httpBasic(hbc->hbc.disable())
              .formLogin(flb->flb.loginProcessingUrl("/login"))
              .build();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
