package com.sternkn.spring.multcontext.platform;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "urn:authentication", name = "AuthenticationInfo")
public class AuthenticationInfo 
{
   private String userId;
   private String site;
   private String language;
   private String terminal;
   
   public AuthenticationInfo()
   {
   }
   
   public String getUserId()
   {
      return userId;
   }
   public void setUserId(String val)
   {
      userId = val;
   }

   public String getSite()
   {
      return site;
   }
   public void setSite(String val)
   {
      site = val;
   }

   public String getLanguage()
   {
      return language;
   }
   public void setLanguage(String val)
   {
      language = val;
   }

   public String getTerminal()
   {
      return terminal;
   }
   public void setTerminal(String val)
   {
      terminal = val;
   }
   
   @Override
   public String toString()
   {
		return "AuthenticationInfo {userId: " + userId 
				   + ", site: " + site 
				   + ", language: " + language 
				   + ", terminal: " + terminal + "}";
   }
}