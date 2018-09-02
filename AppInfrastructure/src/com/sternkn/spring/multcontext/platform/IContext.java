package com.sternkn.spring.multcontext.platform;

/**
 * Represents user's context. Context is a container of 
 * parameters which lifecycle is bounded by some logic (e.g. session context, 
 * request context). 
 * It provides methods for storing attributes with mentioned
 * above lifecycle and sharing them.
 * 
 */
public interface IContext
{
   /**
    * The function returns value of the context attribute with 
    * the name specified.
    * @param name - name of the context attribute
    * @return attribute's value if an attribute with the specified name is 
    * present or <code>null</code> otherwise
    */
   Object getAttribute(String name);
   
   /**
    * Puts new attribute to the context. If an attribute with the specified name
    * already exists, the value of the attribute will be overwritten
    * @param name - name of the attribute
    * @param value -  attribute's value
    */
   void putAttribute(String name, Object value);

   /**
    * Removes an attribute with the specified name. Do nothing if there is no
    * attribute with the given name in the context
    * @param name - name of the attribute to remove from context
    */
   void removeAttribute(String name);

   /**
    * Checks whether context contains any attributes set
    * @return <code>false</code> if there is at least one 
    * attribute in the context.
    */
   boolean isEmpty();
}
