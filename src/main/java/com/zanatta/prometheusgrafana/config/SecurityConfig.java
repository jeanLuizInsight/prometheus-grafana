package com.zanatta.prometheusgrafana.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers("/mgmt/**")
				.hasRole("ACTUATOR")
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic();
	}
}
