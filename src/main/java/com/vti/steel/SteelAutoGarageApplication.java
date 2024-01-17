package com.vti.steel;

import com.vti.steel.entity.Role;
import com.vti.steel.entity.User;
import com.vti.steel.repository.RoleRepository;
import com.vti.steel.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class SteelAutoGarageApplication implements CommandLineRunner {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SteelAutoGarageApplication.class, args);
	}
	@Bean // Cho modelmapper tham gia vào SpringAOC Container
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		var admin = roleRepository.findByType(Role.Type.ADMIN);
		var user = roleRepository.findByType(Role.Type.USER);
		var account = new User();
		account.setName("Trường");
		account.setUsername("truong");
		account.setEmail("truong@gmail.com");
		account.setPassword(passwordEncoder.encode("123456"));
		account.setRoles(Set.of(admin,user));
		userRepository.save(account);

	}
}
