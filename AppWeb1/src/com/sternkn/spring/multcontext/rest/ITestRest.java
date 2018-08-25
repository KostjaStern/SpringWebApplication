package com.sternkn.spring.multcontext.rest;

import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sternkn.spring.multcontext.service.dto.SetupInfo;

@RestController
@RequestMapping(value="/test-rest", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ITestRest 
{
    // WebLogic Server Version: 10.3.6.0
    // http://localhost:7001/web1/rest/test-rest/test
    
    // WebLogic Server Version: 12.2.1.3.0
    // http://localhost:7011/web1/rest/test-rest/julia
	// @PathVariable(value="code")
	
    @RequestMapping(method=RequestMethod.GET)
    SetupInfo getSetup(@RequestParam(value = "code", required = false) String code);
}
