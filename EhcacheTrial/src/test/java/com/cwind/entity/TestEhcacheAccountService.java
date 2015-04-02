package com.cwind.entity;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cwind.ehcache.EhcacheAccountService;

public class TestEhcacheAccountService {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		EhcacheAccountService accountService = (EhcacheAccountService) context.getBean("ehcacheAccountService");
		List<Account> accounts = accountService.getAccounts();
		Account act1 = accountService.getAccount("Billy", accounts);
		System.out.println(act1.toString());
		Account act2 = accountService.getAccount("Billy", accounts);
		System.out.println(act1.toString());
		Account act3 = accountService.getAccount("Ledong", accounts);
		System.out.println(act1.toString());
		System.out.println(accounts.toString());
		List<Account> accounts2 = accountService.getAccounts();
		System.out.println(accounts2.toString());
	}
}
