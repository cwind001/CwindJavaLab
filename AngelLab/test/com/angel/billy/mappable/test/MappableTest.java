package com.angel.billy.mappable.test;

import com.angel.billy.mappable.ErrorStrategy;
import com.angel.billy.mappable.MultiPrompt;

public class MappableTest {
	public static final String DELIMTER = "_";
	public static void main(String[] args){
		ErrorStrategy noInputErrorStrategy = new ErrorStrategy();
		noInputErrorStrategy.getPrompts().add(new MultiPrompt());
		System.out.println(noInputErrorStrategy.toString());
		
		String inputStr = "0_3";
		int multiPromptIndex = Integer.parseInt(inputStr.substring(0,inputStr.indexOf(DELIMTER)));
		int audioFileIndex = Integer.parseInt(inputStr.substring(inputStr.indexOf(DELIMTER)+1));
		System.out.println(multiPromptIndex);
		System.out.println(audioFileIndex);
	}
}
