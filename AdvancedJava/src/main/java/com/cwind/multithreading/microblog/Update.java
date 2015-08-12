package com.cwind.multithreading.microblog;

public class Update {
	private final Author author;
	private final String updateText;
	
	private Update(Builder b_) {
		author = b_.author;
		updateText = b_.updateText;
	}
	
	@Override
	public String toString() {
		return "Update [author=" + author.getName() + ", updateText=" + updateText + "]";
	}

	public static class Builder implements ObjBuilder<Update> {
		private Author author;
		private String updateText;
		
		public Builder author(Author author_) {
			author = author_;
			return this;
		}
		
		public Builder updateText(String updateText_) {
			updateText = updateText_;
			return this;
		}
		
		@Override
		public Update build() {
			return new Update(this);
		}
		
	}
}
