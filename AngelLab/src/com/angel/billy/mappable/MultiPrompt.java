package com.angel.billy.mappable;

import java.util.List;
import java.util.Map;

import com.mstr.util.map.Mappable;
import com.mstr.util.map.MappableList;

public class MultiPrompt implements Mappable{
	List<Prompt> nestedPrompts = new MappableList<Prompt>(Prompt.class);
	boolean reprompt = true;

	public boolean isReprompt() {
		return reprompt;
	}

	public void setReprompt(boolean reprompt) {
		this.reprompt = reprompt;
	}

	public List<Prompt> getNestedPrompts() {
		return nestedPrompts;
	}

	public void setNestedPrompts(List<Prompt> nestedPrompts) {
		this.nestedPrompts = nestedPrompts;
	}

	@Override
	public Map read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Map arg0) {
		// TODO Auto-generated method stub
		
	}

}
