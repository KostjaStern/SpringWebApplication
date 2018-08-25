package com.sternkn.spring.multcontext.service;

import com.sternkn.spring.multcontext.service.dto.SetupInfo;

public interface ISetupService 
{
   SetupInfo getSetupInfo(String code);
}
