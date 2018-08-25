package com.sternkn.spring.multcontext.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Lazy
@EnableWebMvc
@Configuration
public class RestApiFactory 
{
   public RestApiFactory()
   {
	   System.out.println("RestApiFactory");
   }
   
   @Bean
   public ITestRest testRest()
   {
	   System.out.println("RestApiFactory.testRest()");
	   return new TestRest();
   }
}
