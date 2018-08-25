package com.sternkn.spring.multcontext.platform;


import static javax.xml.ws.handler.MessageContext.MESSAGE_OUTBOUND_PROPERTY;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class BindingAuthenticationHandler implements SOAPHandler<SOAPMessageContext>
{
   private static final QName AUTH_QNAME;
   private static final JAXBContext AUTH_CONTEXT = createJaxbContext(AuthenticationInfo.class);

   static {
      XmlRootElement xmlRoot = AuthenticationInfo.class.getAnnotation(XmlRootElement.class);
      AUTH_QNAME = new QName(xmlRoot.namespace(), xmlRoot.name(), "authentication");
   }
	
	
   public BindingAuthenticationHandler()
   {
   }
	
   @Override
   public Set<QName> getHeaders()
   {
      Set<QName> headers = new HashSet<QName>();
      headers.add(AUTH_QNAME);
      return headers;
   }
   
   @Override
   public boolean handleMessage(SOAPMessageContext ctx)
   {
      if ((Boolean) ctx.get(MESSAGE_OUTBOUND_PROPERTY)) return true;
      
      try
      {
         AuthenticationInfo authInfo = getAuthenticationInfo(ctx);
         System.out.println("authInfo = " + authInfo);
         
         Platform.setInvocationContext(createInvocation(ctx));
         AppPlatformHolder.setAuthenticationInfo(authInfo);
      }
      catch (IllegalStateException e)
      {
    	  e.printStackTrace();
      }
      return true;
   }

   private AuthenticationInfo getAuthenticationInfo(SOAPMessageContext ctx)
   {
	  String entity = "Authentication"; 
      try
      {
         SOAPHeader soapHeader = ctx.getMessage().getSOAPHeader();
	         
	     Iterator<?> it = (null == soapHeader) ? null : soapHeader.getChildElements(AUTH_QNAME);
	     if (null == it || !it.hasNext())
	     {
	        String message = String.format("%1s info must be passed in SOAP header", entity);
	        IllegalStateException exception = new IllegalStateException(message);
            throw exception;
	     }
         return (AuthenticationInfo) AUTH_CONTEXT.createBinder().unmarshal((SOAPHeaderElement) it.next());
      }
      catch (JAXBException jaxbException)
      {
         throw new IllegalStateException(String.format("Wrong %1s info", entity), jaxbException);
      }
      catch (SOAPException soapException)
      {
         throw new IllegalStateException(String.format("Wrong %1s info", entity), soapException);
      }
   }

   
   
   @Override
   public void close(MessageContext ctx)
   {
   }

   @Override
   public boolean handleFault(SOAPMessageContext ctx)
   {
      return true;
   }
   
   private static JAXBContext createJaxbContext(Class<?> clazz)
   {
      try
      {
         JAXBContext jaxbContext = JAXBContext
               .newInstance(clazz);

         return jaxbContext;
      }
      catch (JAXBException jaxbException)
      {
         throw new IllegalStateException("Instantiation of JaxbContext failed");
      }
   }


   private SimpleInvocation createInvocation(SOAPMessageContext context)
   {
      HttpServletRequest httpRequest = (HttpServletRequest) context.get(SOAPMessageContext.SERVLET_REQUEST);
      
      SimpleInvocation simpleInvocation = new SimpleInvocation(
            httpRequest.getRemoteAddr(), 
            httpRequest.getRemotePort(), 
            httpRequest.getLocalAddr(),
            httpRequest.getLocalPort(), 
            httpRequest.getProtocol());
      
      return simpleInvocation;
   }

}
