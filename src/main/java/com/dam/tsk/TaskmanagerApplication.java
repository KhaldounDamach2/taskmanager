package com.dam.tsk;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dam.tsk.entity.SB_Roles;
import com.dam.tsk.entity.UserInfo;
import com.dam.tsk.repository.RolesRepository;
import com.dam.tsk.repository.SBUserRepository;

@SpringBootApplication
@EnableWebSecurity
public class TaskmanagerApplication implements CommandLineRunner{

	@Autowired
	 SBUserRepository sbUserRepository;


	@Autowired
	 RolesRepository rolesRepository;


	@Autowired
	 PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SB_Roles roles=new SB_Roles();
		roles.setRoleName("ADMIN");

		rolesRepository.save(roles);
		Set<SB_Roles> sbRolesSet=new HashSet<>();
		sbRolesSet.add(roles);

		UserInfo userInfo=new UserInfo();
		userInfo.setEnabled(true);
		userInfo.setPassword(encoder.encode("admin123"));
		userInfo.setUsername("admin");
		userInfo.setRoles(sbRolesSet);

		sbUserRepository.save(userInfo);

	}
}

