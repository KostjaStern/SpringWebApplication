package com.sternkn.spring.multcontext.platform;

public final class AppPlatformHolder 
{
   public static final String AUTH_ID = "AUTH_ID";

   private AppPlatformHolder()
   {
   }
   
   private static Object getUserAttribute(String attr)
   {
      Object result = Platform.getInvocationContext().getAttribute(attr);
      if (null == result) throw new IllegalStateException("Interaction isn't started.");
      return result;
   }
   
   private static boolean hasUserAttribute(String attr)
   {
      return Platform.getInvocationContext().getAttribute(attr) != null;
   }

   private static void putUserAttribute(String attr, Object value)
   {
      IInvocationContext invocation = Platform.getInvocationContext();
      if (value != null)
      {
         invocation.putAttribute(attr, value);
      }
      else
      {
         invocation.removeAttribute(attr);
      }
   }
   
   public static AuthenticationInfo getAuthenticationInfo()
   {
      return hasUserAttribute(AUTH_ID)
         ? (AuthenticationInfo) getUserAttribute(AUTH_ID)
         : new AuthenticationInfo();
   }
   public static void setAuthenticationInfo(AuthenticationInfo authInfo)
   {
      putUserAttribute(AUTH_ID, authInfo);
   }
}
