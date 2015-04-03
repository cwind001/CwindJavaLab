package com.angel.page;

public class PageCodeAndIDTest {
	public static void main(String[] args){
		String normalStr = "42?0acd3-34f-dfer";
		String onlyPageCodeStr = "42";
		String zeroNormalStr = "0?0acd3-34f-dfer";
		String zeroOnlyPageCodeStr = "0";
		String doNotConnectStr = "0?";
		String onlyIDStr = "?0acd3-34f-def3";
		String onlyQuestionStr = "?";
		String emptyStr = "";
		String nullStr = null;
		
//		String[] result = normalStr.split("\\?");
//		String[] result = onlyPageCodeStr.split("\\?");
//		String[] result = zeroNormalStr.split("\\?");
//		String[] result = zeroOnlyPageCodeStr.split("\\?");
//		String[] pageCodeIDArray = normalStr.split("\\?");
//		String[] pageCodeIDArray = nullStr.split("\\?");
		
//		System.out.println(pageCodeIDArray.length);
		
		String pageCode = getPageCodeByDestination(nullStr);
		String pageID = getPageIDByDestination(nullStr);

		System.out.println("Page code - " + pageCode);
		System.out.println("Page ID - " + pageID);
	}
	
	/**
	 *  This function will get page code from destination string in both types:
	 *  1. pageCode (as used before) 2. pageCode?pageID (new format)
	 *  Suppose the destination is correct, merely parsing, no check
	 *  PR-11769, PR-11789, billy, bob
	 *    String normalStr = "42?0acd3-34f-dfer"; //return 42
		  String onlyPageCodeStr = "42"; // 42
		  String zeroNormalStr = "0?0acd3-34f-dfer"; //0
		  String zeroOnlyPageCodeStr = "0"; //0
		  String doNotConnectStr = "0?"; //0
		  String onlyIDStr = "?0acd3-34f-def3"; //""
		  String onlyQuestionStr = "?"; //""
	 * @param destination
	 * @return page code
	 */
	public static String getPageCodeByDestination(String destination){
		if(destination == null){
			return null;
		}
		
		String[] pageCodeIDArray = destination.split("\\?");
		String pageCode = "";
		if(pageCodeIDArray.length>=1 && isNumeric(pageCodeIDArray[0])){
			pageCode = pageCodeIDArray[0];
		}
		return pageCode;		
	}
	
	/**
	 *  This function will get page id from destination string in both types:
	 *  1. pageCode (as used before) 2. pageCode?pageID (new format)
	 *  Suppose the destination is correct, merely parsing, no check
	 *  PR-11769, PR-11789, bob, billy
	 *   *    String normalStr = "42?0acd3-34f-dfer"; //return 0acd3-34f-dfer
		  String onlyPageCodeStr = "42"; // ""
		  String zeroNormalStr = "0?0acd3-34f-dfer"; //0acd3-34f-dfer
		  String zeroOnlyPageCodeStr = "0"; //""
		  String doNotConnectStr = "0?"; //""
		  String onlyIDStr = "?0acd3-34f-def3"; //0acd3-34f-def3
		  String onlyQuestionStr = "?"; //""
	 * @param destination
	 * @return page id
	 */
	public static String getPageIDByDestination(String destination){
		if(destination == null){
			return null;
		}
		String[] pageCodeIDArray = destination.split("\\?");
		String pageID = "";
		if(pageCodeIDArray.length > 1 && !isNumeric(pageCodeIDArray[1])){
			pageID = pageCodeIDArray[1];
		}
		return pageID;
	}
	
	/**
	 * returns true if String s is all numeric.
	 */
	public static boolean isNumeric(String s)
	{
		// -- if this is a blank string or null we must return false
		if (isBlank(s))
			return false;

		char[] chars = s.toCharArray();

		for (char c : chars)
		{
			if (!(Character.isDigit(c)))
				return false;
		}

		return true;
	}
	
	/**
	 * return true if String s is empty or null or full of whitespace
	 */
	public static boolean isBlank(String s)
	{
		return (s == null || s.trim().length() == 0);
	}

}
