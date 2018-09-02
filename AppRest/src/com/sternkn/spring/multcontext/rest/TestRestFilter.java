package com.sternkn.spring.multcontext.rest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sternkn.spring.multcontext.platform.AppPlatformHolder;
import com.sternkn.spring.multcontext.platform.AuthenticationInfo;
import com.sternkn.spring.multcontext.platform.Platform;
import com.sternkn.spring.multcontext.platform.SimpleInvocation;

public class TestRestFilter implements Filter 
{
   private WebApplicationContext springContext;
   private AuthenticationInfo authInfo;

   public TestRestFilter()
   {
   }

   @Override
   public void init(FilterConfig filterConfig)
   {
	   System.out.println("TestRestFilter.init() ... ");
	   ServletContext context = filterConfig.getServletContext();
	   springContext = WebApplicationContextUtils.getWebApplicationContext(context);
	   authInfo = springContext.getBean(AuthenticationInfo.class);
//	   System.out.println("TestRestFilter.init authInfo = " + authInfo);
   }
   
   @Override
   public void doFilter(ServletRequest request, ServletResponse response,
           FilterChain chain) throws IOException, ServletException
   {
//	   ServletContext context = request.getServletContext();
//	   WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(context);
	   
	   System.out.println("TestRestFilter.doFilter ...");
//	   System.out.println("request.getProtocol() = " + request.getProtocol());
//	   System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
//	   System.out.println("request.getRemotePort() = " + request.getRemotePort());
//	   System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
//	   System.out.println("request.getLocalPort() = " + request.getLocalPort());
	   
//	   System.out.println("authInfo.hashCode() = " + authInfo.hashCode());
	   
//	   AuthenticationInfo authInfo = springContext.getBean(AuthenticationInfo.class);
//	   System.out.println("authInfo.hashCode() = " + authInfo.hashCode());
	   
	   SimpleInvocation simpleInvocation = new SimpleInvocation(
	    		  request.getRemoteAddr(), 
	    		  request.getRemotePort(), 
	    		  request.getLocalAddr(),
	    		  request.getLocalPort(), 
	    		  request.getProtocol());
	   Platform.setInvocationContext(simpleInvocation);
       AppPlatformHolder.setAuthenticationInfo(authInfo);
       
       chain.doFilter(request, response);
   }
   
   @Override
   public void destroy()
   {
	   System.out.println("TestRestFilter.destroy() ... ");
   }
}
