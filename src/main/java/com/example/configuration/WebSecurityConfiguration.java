package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.security.Filter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Filter filter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/anon").permitAll()
				.antMatchers(HttpMethod.GET, "/default").hasRole("DEFAULT")
				.antMatchers(HttpMethod.GET, "/admin").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/users/default", "/login").permitAll()
				.antMatchers(HttpMethod.POST, "/users/admin").hasRole("ADMIN")
				.anyRequest().authenticated();
	}
	
}
