package com.sternkn.spring.multcontext.platform;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppPlatformServletContextListener implements ServletContextListener 
{
   public AppPlatformServletContextListener()
   {
   }
   
   @Override
   public void contextDestroyed(ServletContextEvent sce)
   {
   }

   @Override
   public void contextInitialized(ServletContextEvent sce)
   {
      System.out.println("AppPlatformServletContextListener . contextInitialized");
      System.out.println("ServletContextEvent.getSource() = " + sce.getSource());
      
      // Platform.setInvocationBinder(new ThreadLocalBinder<IInvocationContext>());
   }
}
