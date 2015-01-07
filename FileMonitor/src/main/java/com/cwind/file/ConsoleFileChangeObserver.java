package com.cwind.file;

public class ConsoleFileChangeObserver implements FileChangeObserver {

	@Override
	public void fileChanged(String filename) {
		System.out.println("Console: File " + filename + " is changed, will print warning message to console.");
	}
}
