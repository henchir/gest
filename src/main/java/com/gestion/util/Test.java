package com.gestion.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestion.service.Test1Service;
import com.gestion.service.TestService;
import com.gestion.service.UsersService;

public class Test {

	private static ApplicationContext context,context1,context2;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context1 = new ClassPathXmlApplicationContext("applicationContext1.xml");
		context2 = new ClassPathXmlApplicationContext("applicationContext2.xml");
		UsersService usrSrv = (UsersService) context.getBean("usrSrv");
		TestService testSrv = (TestService) context1.getBean("tstSrv");
		Test1Service test1Srv = (Test1Service) context2.getBean("tst1Srv");

		try {
//			Users user = new Users(String.format("CIN %d", 0), String.format("NOM %d", 0),
//					String.format("PRENOM %d", 0), String.format("TEL %d", 0), String.format("EMAIL %d", 0),
//					String.valueOf(0), String.valueOf(0), true, "ROLE_ADMIN");
			System.out.println(String.valueOf(testSrv.countPage()));
			System.out.println(String.valueOf(usrSrv.countPage()));
			System.out.println(String.valueOf(test1Srv.countPage()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
