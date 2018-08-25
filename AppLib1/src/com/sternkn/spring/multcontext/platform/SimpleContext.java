package com.sternkn.spring.multcontext.platform;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SimpleContext implements IContext, Serializable
{
   private static final long serialVersionUID = 3151166301918783097L;
   private Map<String, Object> attributes = new HashMap<String, Object>();
   
   public SimpleContext()
   {
   }
   
   @Override
   public synchronized Object getAttribute(String name)
   {
      return attributes.get(name);
   }

   @Override
   public synchronized void putAttribute(String name, Object value)
   {
      attributes.put(name, value);
   }
   
   @Override
   public synchronized void removeAttribute(String name)
   {
      attributes.remove(name);
   }

   @Override
   public synchronized boolean isEmpty()
   {
      return attributes.isEmpty();
   }

   public synchronized void clear()
   {
      attributes.clear();
   }
}