package com.sternkn.spring.multcontext.platform;

public class ThreadLocalBinder<T> implements IBinder<T>
{
   private ThreadLocal<T> bindingHolder = new ThreadLocal<T>(); 
   
   @Override
   public T resolveCurrentBinding()
   {
      T binding = bindingHolder.get();
      if (binding == null) throw new IllegalStateException();
      return binding;
   }

   @Override
   public void bindThread(T binding)
   {
      bindingHolder.set(binding);
   }

   @Override
   public void unbindThread()
   {
      bindingHolder.set(null);
   }
}