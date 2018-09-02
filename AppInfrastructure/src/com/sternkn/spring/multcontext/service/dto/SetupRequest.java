package com.sternkn.spring.multcontext.service.dto;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;

// @XmlAccessorType(XmlAccessType.PUBLIC_MEMBER) ??
public class SetupRequest 
{
   private boolean readOnly;
   private String code;
	
   public SetupRequest()
   {
   }

   public boolean isReadOnly()
   {
      return readOnly;
   }
   public void setReadOnly(boolean val)
   {
      readOnly = val;
   }
   
   public String getCode()
   {
	   return code;
   }
   public void setCode(String val)
   {
      code = val;
   }
}
