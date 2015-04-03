package com.cwind.enumer;

import com.cwind.enumer.Meta.PROMPT_LEVEL;

public class RepromptLevelTest {
	
	private PROMPT_LEVEL noInputPromptLevel = PROMPT_LEVEL.SITE_LEVEL;
	private PROMPT_LEVEL noMatchPromptLevel = PROMPT_LEVEL.PAGE_LEVEL;
	
	public PROMPT_LEVEL getNoInputPromptLevel() {
		return noInputPromptLevel;
	}

	public void setNoInputPromptLevel(PROMPT_LEVEL noInputPromptLevel) {
		this.noInputPromptLevel = noInputPromptLevel;
	}

	public PROMPT_LEVEL getNoMatchPromptLevel() {
		return noMatchPromptLevel;
	}

	public void setNoMatchPromptLevel(PROMPT_LEVEL noMatchPromptLevel) {
		this.noMatchPromptLevel = noMatchPromptLevel;
	}

	public static void main(String[] args){
		RepromptLevelTest rlt = new RepromptLevelTest();
		PROMPT_LEVEL noinput = rlt.getNoInputPromptLevel();

		System.out.println(noinput);
		
		rlt.setNoInputPromptLevel(PROMPT_LEVEL.PAGE_LEVEL);
		noinput = rlt.getNoInputPromptLevel();
		
		if (noinput.equals(PROMPT_LEVEL.SITE_LEVEL)){
			System.out.println("Site level sub routine...");
		}

		if (noinput.equals(PROMPT_LEVEL.PAGE_LEVEL)){
			System.out.println("Page level sub routine...");
		}
		System.out.println("No input level - "+noinput);
		int count = 1;
		System.out.println(count);
		count++;
		System.out.println(count);
		
		
	}
}
