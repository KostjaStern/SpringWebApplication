package com.sternkn.spring.multcontext.service;

import org.springframework.stereotype.Service;

import com.sternkn.spring.multcontext.platform.AppPlatformHolder;
import com.sternkn.spring.multcontext.platform.AuthenticationInfo;
import com.sternkn.spring.multcontext.service.dto.SetupInfo;

@Service
public class SetupService implements ISetupService 
{

	@Override
	public SetupInfo getSetupInfo(String code)
	{
		AuthenticationInfo authInfo = AppPlatformHolder.getAuthenticationInfo();
		
		String site = authInfo.getSite();
		String user = authInfo.getUserId();
		
		System.out.println("SetupService.getSetupInfo site = " + site);
		System.out.println("SetupService.getSetupInfo user = " + user);
		
		SetupInfo setupInfo = new SetupInfo(code, this.toString());
		
		try {
			System.out.println("SetupService.getSetupInfo Thread.currentThread().getId() = " + Thread.currentThread().getId());
			System.out.println("SetupService.getSetupInfo Thread.currentThread().getName() = " + Thread.currentThread().getName());
			Thread.sleep(10000);
			
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("SetupService.getSetupInfo site1 = " + site);
		System.out.println("SetupService.getSetupInfo user1 = " + user);
		System.out.println("SetupService.getSetupInfo done ...");
		return setupInfo;
	}
}
