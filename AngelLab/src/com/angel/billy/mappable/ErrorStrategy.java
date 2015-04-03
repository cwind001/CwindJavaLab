package com.angel.billy.mappable;

import java.util.List;
import java.util.Map;

import com.mstr.util.map.Mappable;
import com.mstr.util.map.MappableList;

public class ErrorStrategy implements Mappable{
	List<MultiPrompt> prompts = new MappableList<MultiPrompt>(MultiPrompt.class);
	List<Prompt> helpPrpmpts = new MappableList<Prompt>(Prompt.class);

	@Override
	public Map read() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MultiPrompt> getPrompts() {
		return prompts;
	}

	public void setPrompts(List<MultiPrompt> prompts) {
		this.prompts = prompts;
	}

	public List<Prompt> getHelpPrpmpts() {
		return helpPrpmpts;
	}

	public void setHelpPrpmpts(List<Prompt> helpPrpmpts) {
		this.helpPrpmpts = helpPrpmpts;
	}

	@Override
	public void update(Map arg0) {
		// TODO Auto-generated method stub
		
	}

}
