package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	//@Bean :spring 부품 : configuration 에서 주로 사용하는 어노테이션
	@Bean
	public UserDetailsService  userDetailsService(PasswordEncoder passwordEncoder){
			
			UserDetails user = User.builder()
					.username("user")
					//.password("{noop}1234")
					.password(passwordEncoder.encode("password"))
					.roles("USER")
					.build();
			UserDetails admin = User.builder()
					.username("admin")
					//.password("{noop}1234")
					.password(passwordEncoder.encode("password"))
					.roles("USER","ADMIN")
					.build();
			return new InMemoryUserDetailsManager(user,admin);
	}
	
	
	//password BCrypt 암호화 해주는 함수
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
