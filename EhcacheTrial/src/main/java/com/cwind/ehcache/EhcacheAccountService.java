package com.cwind.ehcache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.cwind.entity.Account;

@Component("ehcacheAccountService")
public class EhcacheAccountService {

	@Cacheable(value="accountEhCache")
	public List<Account> getAccounts() {
		System.out.println("*** Actual query from DB ***");
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("Billy"));
		accounts.add(new Account("Alan"));
		accounts.add(new Account("Bob"));
		accounts.add(new Account("Ledong"));
		accounts.add(new Account("Kyle"));
		return accounts;
	}

	@Cacheable(value="accountEhCache", key="#name")
	public Account getAccount(String name, List<Account> accounts) {
		System.out.println("### Get account by name: " + name + " ###");
		Account act = null;
		for(Account account : accounts) {
			if(account.getName().equalsIgnoreCase(name)) {
				act = account;
				break;
			}
		}
		return act;
	}
}
