package gft.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import gft.entities.UserEntity;
import gft.repositories.UserRepository;
import gft.services.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	final UserDetailsServiceImpl userDetailsService;
	final UserRepository userRepository;
	
	public WebSecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl, UserRepository userRepository) {
		this.userDetailsService = userDetailsServiceImpl;
		this.userRepository = userRepository;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		    .httpBasic()
		    .and()
		    .authorizeHttpRequests()
		    .anyRequest().authenticated()
		    .and()
		    .csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication()
			.withUser("Michel")
			.password(passwordEncoder().encode("123"))
			.roles("ADMIN");
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
