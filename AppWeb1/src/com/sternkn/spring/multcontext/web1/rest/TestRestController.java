package com.sternkn.spring.multcontext.web1.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sternkn.spring.multcontext.service.ISampleService;

@RestController
@RequestMapping("/test-rest/{name}")
public class TestRestController 
{
    private ISampleService sampleService;
    
    // WebLogic Server Version: 10.3.6.0
    // http://localhost:7001/web1/rest/test-rest/test
    
    // @RequestMapping(value="/{name}", method=RequestMethod.GET)
    @GetMapping
    public String getUser(@PathVariable(value="name") String name)
    {
        String result = "Hello " + name + "\n";
        result = result + sampleService.sayHello(name);
        return result;
    }
    
    @Autowired
    public void setSampleService(ISampleService val)
    {
       sampleService = val;
    }
}
