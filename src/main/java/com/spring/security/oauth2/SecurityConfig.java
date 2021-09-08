package com.spring.security.oauth2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(a -> a
                .antMatchers("/", "/error").permitAll()
                .anyRequest().authenticated()
            )
            .exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            )
            .oauth2Login()
            .and().addFilterBefore(new CustomFilter(), DefaultLoginPageGeneratingFilter.class);
        
        //org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter
        //org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter
    }
}
