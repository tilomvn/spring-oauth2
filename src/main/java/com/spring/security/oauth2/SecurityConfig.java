package com.spring.security.oauth2;


import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;


public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(a -> a.antMatchers("/", "/error").permitAll()
            						 .anyRequest().authenticated()
            )
            .exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
            .oauth2Login()
            .and().addFilterAfter(new CustomFilter(), OAuth2AuthorizationRequestRedirectFilter.class); // did not apply filter ???
        
        //org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter
        //org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter
        //org.springframework.security.oauth2.client.web.OAuth2AuthorizationCodeGrantFilter
    }
}
