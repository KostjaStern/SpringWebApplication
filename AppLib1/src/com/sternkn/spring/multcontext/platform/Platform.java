package com.sternkn.spring.multcontext.platform;


public final class Platform
{
   private static final IBinder<IInvocationContext> DEFAULT_INVOCATION_BINDER 
      = new IBinder<IInvocationContext>()
      {
         @Override
         public void unbindThread()
         {
            throw new UnsupportedOperationException();
         }
   
         @Override
         public IInvocationContext resolveCurrentBinding()
         {
            throw new UnsupportedOperationException();
         }
   
         @Override
         public void bindThread(IInvocationContext object)
         {
            throw new UnsupportedOperationException();
         }
      };
      
   private static IBinder<IInvocationContext> invocationBinder;

   private Platform()
   {
   }
   
   /**
    * It returns an instance of invocation context.
    * It's never <code>null</code>. 
    * If no invocation context has been bound than it throws
    * <code>NoBindingException</code> exception.
    * 
    * @return an instance of bound invocation context.
    * @exception com.softcomputer.softlab.platform.context.NoBindingException -
    *               if no invocation has been bound.
    */
   public static synchronized IInvocationContext getInvocationContext()
   {
      IBinder<IInvocationContext> binder = getInvocationBinder();
      IInvocationContext invocationContext = binder.resolveCurrentBinding();
      return invocationContext;
   }
   
   public static synchronized void setInvocationContext(
         IInvocationContext invocationContext)
   {
      getInvocationBinder().bindThread(invocationContext);
   }
   
   public static synchronized void removeInvocation()
   {
      getInvocationBinder().unbindThread();
   }
   
   private static IBinder<IInvocationContext> getInvocationBinder()
   {
      return invocationBinder == null ? DEFAULT_INVOCATION_BINDER
            : invocationBinder;
   }
   
   public static void setInvocationBinder(IBinder<IInvocationContext> binder)
   {
      Platform.invocationBinder = binder;
   }
}