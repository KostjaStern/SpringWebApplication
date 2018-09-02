package com.sternkn.spring.multcontext.platform;

/**
 * It represent a context linked to invocation.
 */
public interface IInvocationContext extends IContext
{
   /**
    * Host name of invoker. 
    * @return host name or null.
    */
   String getInvokerHost();

   /**
    * Port of invoker or null.
    * @return  port number or null.
    */
   Integer getInvokerPort();

   /**
    * Host name or running application.
    * @return name of application host or null.
    */
   String getLocalHost();

   /**
    * Port name or null of runing application.
    * @return application port number or null.
    */
   Integer getLocalPort();
   
   /**
    * Returns protocol name or null if not stated.
    * @return name of protocol or null.
    */
   String getProtocol();
}
