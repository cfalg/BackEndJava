package com.itacademy.s0502_JocDaus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.itacademy.s0502_JocDaus.Model.Security.JWTAuthorizationFilter;

@SpringBootApplication
public class S0502JocDausApplication {

	public static void main(String[] args) {
		SpringApplication.run(S0502JocDausApplication.class, args);
	}
	
    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter{
       
        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.csrf().disable()
                 .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                 .authorizeRequests()
                 .antMatchers(HttpMethod.POST, "/user").permitAll()
                 .anyRequest().authenticated();
        }
    }

}
