package com.spring.security.oauth2;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;


class CustomFilter extends GenericFilterBean {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		logger.info(request.getServletContext().getContextPath());
		
		chain.doFilter(request, response);
	}

}
