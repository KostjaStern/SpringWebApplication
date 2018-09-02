package com.sternkn.spring.multcontext.web2;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sternkn.spring.multcontext.service.ISampleService;

/**
 * Servlet implementation class for Servlet: SecondServlet
 * http://localhost:7001/web2/second
 */
public class SecondServlet extends HttpServlet implements Servlet 
{
    private static final long	serialVersionUID	= 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        // For this sample, we simply perform depency lookup from the current WebApplicationContext. 
        // This will query the shared parent context and find the sampleService bean.
        // In a real web app, Spring provide a better way to do dependency injection
        // of your web controllers/actions/whatever your web framework calls them.
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        ISampleService service = (ISampleService) ctx.getBean("sampleService");
        
        response.getWriter().println(service.sayHello("SampleWeb2") + " using service instance " + service);
    }
}