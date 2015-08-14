package com.cwind.string;

/**
 * @author wchen
 * 8/13/2015
 */
public class TrimFileName {
	
	//Put this in StringUtils if necessary.
	public static String trimFileName(String filename){
		return filename.substring(filename.lastIndexOf("/")+1);
	}

	public static void main(String[] args){
		String filename = "0ac53286-04-1447666b4d2-1f788bc5-256/test_directory/1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890.wav";
		System.out.println("Original file name: "+filename+", length: "+filename.length());
		String trimmedFileName = trimFileName(filename);
		System.out.println("Trimmed file name: "+ trimmedFileName+", length: "+trimmedFileName.length());
	}
}
