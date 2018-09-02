package com.sternkn.spring.multcontext.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sternkn.spring.multcontext.platform.AuthenticationInfo;


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
   
   @Bean(name="authInfo")
   @Scope(value=SCOPE_REQUEST, proxyMode=ScopedProxyMode.TARGET_CLASS)
   public AuthenticationInfo authInfo()
   {
	   System.out.println("RestApiFactory.authInfo() ...");
	   
	   AuthenticationInfo authInfo = new AuthenticationInfo();
	   authInfo.setSite("WW");
	   authInfo.setUserId(String.valueOf(authInfo.hashCode()));
	   return authInfo;
   }
}
