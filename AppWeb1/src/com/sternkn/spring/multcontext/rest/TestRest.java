package com.sternkn.spring.multcontext.rest;

import org.springframework.beans.factory.annotation.Autowired;

import com.sternkn.spring.multcontext.service.ISetupService;
import com.sternkn.spring.multcontext.service.dto.SetupInfo;


public class TestRest implements ITestRest
{
    private ISetupService setupService;
    
    @Override
    public SetupInfo getSetup(String code)
    {
        SetupInfo setupInfo = setupService.getSetupInfo(code);
        return setupInfo;
    }
    
    @Autowired
    public void setSetupService(ISetupService val)
    {
       setupService = val;
    }
}
