package com.sternkn.spring.multcontext.web1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.sternkn.spring.multcontext.service.ISampleService;

/**
 * Servlet implementation class for Servlet: FirstServlet
 * http://localhost:7001/web1/first
 */
public class FirstServlet extends HttpServlet implements Servlet
{
    private static final long serialVersionUID = 1L;
   
    private ISampleService sampleService;

    @Override
    public void init(ServletConfig config)
    {
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.getWriter().println(sampleService.sayHello("SampleWeb1") + " using service instance " + sampleService);
    }

    @Autowired
    public void setSampleService(ISampleService val)
    {
       sampleService = val;
    }
}