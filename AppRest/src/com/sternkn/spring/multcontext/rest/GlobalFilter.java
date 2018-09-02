package com.sternkn.spring.multcontext.rest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class GlobalFilter implements Filter 
{
   public GlobalFilter()
   {
   }
   
   @Override
   public void init(FilterConfig filterConfig)
   {
	   System.out.println("GlobalFilter.init() ... ");
   }
   
   @Override
   public void doFilter(ServletRequest request, ServletResponse response,
           FilterChain chain) throws IOException, ServletException
   {
	   System.out.println("GlobalFilter.doFilter ... ");
       
       chain.doFilter(request, response);
   }
   
   @Override
   public void destroy()
   {
	   System.out.println("GlobalFilter.destroy() ... ");
   }

}
