package com.sternkn.spring.multcontext.web2;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.sternkn.spring.multcontext.service.ISetupService;
import com.sternkn.spring.multcontext.service.dto.SetupInfo;
import com.sternkn.spring.multcontext.service.dto.SetupRequest;

@WebService(name="SetupWWW")
@SOAPBinding(parameterStyle = ParameterStyle.BARE)
@HandlerChain(file = "soaphandlers.xml")
public class SetupWS extends SpringBeanAutowiringSupport 
{
   private ISetupService setupService;
   
   @WebMethod
   public SetupInfo getSetupInfo(SetupRequest request)
   {
	   String code = request.getCode();
	   System.out.println("request.getCode() = " + code);
	   return setupService.getSetupInfo(code);
   }
   
   @Autowired
   @WebMethod(exclude = true)
   public void setSetupService(ISetupService val)
   {
      setupService = val;
   }
}
