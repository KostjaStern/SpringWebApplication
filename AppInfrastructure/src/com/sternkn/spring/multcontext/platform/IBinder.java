package com.sternkn.spring.multcontext.platform;

public interface IBinder<T>
{
   T resolveCurrentBinding();

   void bindThread(T object);

   void unbindThread();
}
