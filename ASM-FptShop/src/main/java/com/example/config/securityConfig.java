package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.service.CustomAccountService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
@Configuration
@EnableWebSecurity
public class securityConfig {
	@Autowired CustomAccountService customAccountService;
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests((auth) -> auth					
	            .requestMatchers("/User/Products/Show", "/User/Products/details/{id}", "/Account/**","/rest/**" ).permitAll()
	            .requestMatchers("/css/**", "/images/**", "/img/**", "/js/**", "/scss/**", "/vendor/**").permitAll()
	            .requestMatchers("/Admin/**").hasAuthority("Admin")	            
	            .anyRequest().authenticated()
	        )
	        .formLogin(login -> login
	            .loginPage("/Account/login/show")
	            .loginProcessingUrl("/Account/login")
	            .usernameParameter("username")
	            .passwordParameter("password")
	            .defaultSuccessUrl("/User/Products/Show")
	            .failureUrl("/Account/login/show?error")  // Xác định URL khi đăng nhập thất bại
	            
	        ).logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/Account/login/show"));
	    
	    return http.build();
	}

//
//	   @Bean 
//	   WebSecurityCustomizer webSecurityCustomizer()
//	   {
//		   return (web)->web.ignoring().requestMatchers("/static/**");
//	   }
	    
}
