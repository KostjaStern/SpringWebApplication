package com.sternkn.spring.multcontext.platform;

import java.io.Serializable;

/**
 * A simple implementation of <code>IInvocation</code>.
 */
public class SimpleInvocation extends SimpleContext implements
      IInvocationContext, Serializable
{
   private static final long serialVersionUID = -4501920355020428966L;

   private final String invokerHost;

   private final Integer invokerPort;

   private final String localHost;

   private final Integer localPort;

   private final String protocol;

   public SimpleInvocation(String invokerHost, Integer invokerPort,
         String localHost, Integer localPort, String protocol)
   {
      this.invokerHost = invokerHost;
      this.invokerPort = invokerPort;
      this.localHost = localHost;
      this.localPort = localPort;
      this.protocol = protocol;
   }

   @Override
   public String getInvokerHost()
   {
      return invokerHost;
   }

   @Override
   public Integer getInvokerPort()
   {
      return invokerPort;
   }

   @Override
   public String getLocalHost()
   {
      return localHost;
   }

   @Override
   public Integer getLocalPort()
   {
      return localPort;
   }

   @Override
   public String getProtocol()
   {
      return protocol;
   }
}