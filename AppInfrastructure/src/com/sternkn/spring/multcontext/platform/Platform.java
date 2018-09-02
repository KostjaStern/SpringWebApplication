package com.sternkn.spring.multcontext.platform;


public final class Platform
{
   private static final IBinder<IInvocationContext> invocationBinder;
   static {
	   System.out.println("Platform initialization ...");
	   System.out.println("Platform Thread.currentThread().getId() = " + Thread.currentThread().getId());
	   System.out.println("Platform Thread.currentThread().getName() = " + Thread.currentThread().getName());
		
	   invocationBinder = new ThreadLocalBinder<IInvocationContext>();
   }

   private Platform()
   {
   }
   
   public static synchronized IInvocationContext getInvocationContext()
   {
      return invocationBinder.resolveCurrentBinding();
   }
   public static synchronized void setInvocationContext(IInvocationContext context)
   {
      invocationBinder.bindThread(context);
   }
   
   public static synchronized void removeInvocation()
   {
      invocationBinder.unbindThread();
   }

}