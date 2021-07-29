package com.kiranaher.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
 
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Value( "${app.allow.origins}" )
    private String allowOrigins;
	
	public void addCorsMapping(CorsRegistry registry) {
		  registry.addMapping("/**")
          //.allowedOrigins("http://localhost")
          .allowedOrigins(allowOrigins)
          .allowedMethods("PUT", "DELETE","GET", "POST");
		
	}
	

            }