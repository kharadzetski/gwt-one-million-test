package com.example.server;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

public abstract class AutowiringService {

	public AutowiringService() {
		HttpServletRequest request = RequestFactoryServlet.getThreadLocalRequest();
		ServletContext servletContext = request.getSession().getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        if (context == null) {
            throw new IllegalStateException("No Spring web application context found");
        }
		context.getAutowireCapableBeanFactory().autowireBeanProperties(this,
	            AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
	}
}
