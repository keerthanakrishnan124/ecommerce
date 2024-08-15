package com.example.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.ecommerce.service.MyUserDetailsService;




@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Autowired
	private MyUserDetailsService myUserDetailsServie;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(customizer -> customizer.disable())
			.authorizeHttpRequests(registry->
			registry
			.requestMatchers("/home","/register","/login").permitAll()
//			.requestMatchers("/admin/**").hasRole("ADMIN")
//			.requestMatchers("/user/**").hasRole("USER")
			.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults())
			.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			.build();
	
	}
	
//	@Bean
//	public UserDetailsService userDetailsServive() {
//		UserDetails normalUser=User.builder()
//				.username("ab")
//				.password("$2a$12$ymj8nv1XgE9kOuB6/68aY.eOUdD4TaS5kjSeSb0Xvn/snHSgApeki")
//				.roles("USER")
//				.build();
//		UserDetails adminUser=User.builder()
//				.username("admin")
//				.password("$2a$12$HnLvHzbpMYnY4LIhOvehlONjMx1qVmWMm4IZ9BYU8GDWsYag9RRiW")
//				.roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(normalUser,adminUser);
//	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return myUserDetailsServie;
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(myUserDetailsServie);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();

	    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
}
