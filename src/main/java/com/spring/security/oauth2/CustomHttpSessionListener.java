package com.spring.security.oauth2;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebListener
public class CustomHttpSessionListener implements HttpSessionListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("Session destroyed: " + se.getSession().getId());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("Session created: " + se.getSession().getId());
    }
}
