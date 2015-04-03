package com.cwind.inherit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ASRLanguageParse {
	public static void main(String[] args){
		String allowedLanguages = "Spanish/Chinese/Japanese/";
		String[] langArray = allowedLanguages.split("/");
		List langlist = Arrays.asList(langArray);
		for (String language:langArray){
			System.out.println(language);
		}
		System.out.println(langlist.contains("spanish"));
		
		Person person = new Person();
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getLazyDogs());
		
		String hangupPageStr = "7f000001-03-13b88a58882-d5a596ae-599,7f000001-03-13b88a6929d-fe40555f-599,7f000001-03-13b88a58882-d5a596ae-599,,,";
		String[] hangupPages = hangupPageStr.split(",");
		
		HashMap pageMap = new HashMap<String,String>();
		try {
			for (String hangupPage : hangupPages) {
				if (pageMap.get(hangupPage) == null) {
					pageMap.put(hangupPage, hangupPage);
				} else {
					System.out.println("duplicated hang up pages found");
					throw new Exception();
				}
				System.out.println(hangupPage + " " + pageMap.get(hangupPage));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
