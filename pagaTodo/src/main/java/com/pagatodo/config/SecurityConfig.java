package com.pagatodo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public UserDetailsService users() {
		UserBuilder users = User.withDefaultPasswordEncoder();
		UserDetails user = users
			.username("user")
			.password("password")
			.roles("USER")
			.authorities("USER")
			.build();
		UserDetails admin = users
			.username("admin")
			.password("password")
			.roles("ADMIN")
			.authorities("ADMIN")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.authorizeHttpRequests((authorize) -> authorize
        			.requestMatchers(HttpMethod.GET, "/pagaTodo/emp/v1/empleados").hasRole("USER")
        			.requestMatchers(HttpMethod.GET, "/pagaTodo/emp/v1/empleado/{id}").hasRole("USER")
        			.requestMatchers(HttpMethod.DELETE, "/pagaTodo/emp/v1/empleado/{id}").hasRole("ADMIN")
        			.requestMatchers(HttpMethod.PUT, "/pagaTodo/emp/v1/empleado/{id}").hasRole("ADMIN")
        			.requestMatchers(HttpMethod.POST, "/pagaTodo/emp/v1/empleadoAlta").hasRole("ADMIN")
                    .anyRequest().authenticated()
                )
            .httpBasic()
            .and()
            .csrf().disable();
        return http.build();
    }
}

