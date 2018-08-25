package com.sternkn.spring.multcontext.rest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sternkn.spring.multcontext.platform.AppPlatformHolder;
import com.sternkn.spring.multcontext.platform.AuthenticationInfo;
import com.sternkn.spring.multcontext.platform.Platform;
import com.sternkn.spring.multcontext.platform.SimpleInvocation;

public class TestRestFilter implements Filter 
{
   public TestRestFilter()
   {
   }

   @Override
   public void init(FilterConfig filterConfig)
   {
	   System.out.println("TestRestFilter.init() ... ");
   }
   
   @Override
   public void doFilter(ServletRequest request, ServletResponse response,
           FilterChain chain) throws IOException, ServletException
   {
	   AuthenticationInfo authInfo = new AuthenticationInfo();
	   authInfo.setSite("WW");
	   authInfo.setUserId("REST");
	   
	   System.out.println("TestRestFilter.doFilter ...");
	   System.out.println("request.getProtocol() = " + request.getProtocol());
	   System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
	   System.out.println("request.getRemotePort() = " + request.getRemotePort());
	   System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
	   System.out.println("request.getLocalPort() = " + request.getLocalPort());
	   
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
