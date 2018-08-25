package com.sternkn.spring.multcontext.service.dto;

public class SetupInfo 
{
   private String code;
   private String description;

   public SetupInfo()
   {
   }
   
   public SetupInfo(String code, String description)
   {
      this.code = code;
      this.description = description;
   }
   
   public String getCode()
   {
      return code;
   }
   public void setCode(String val)
   {
      code = val;
   }
   
   public String getDescription()
   {
      return description;
   }
   public void setDescription(String val)
   {
      description = val;
   }
   
}
