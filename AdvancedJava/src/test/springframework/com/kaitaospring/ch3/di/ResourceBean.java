package com.kaitaospring.ch3.di;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResourceBean {

	private FileOutputStream fos;
	private File file;
	
	public void init() {
		System.out.println("ResourceBean:-----init");
		System.out.println("ResourceBean:-----loading resource");
		
		try{
			this.fos = new FileOutputStream(file);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		System.out.println("ResourceBean:-----destroy");
		System.out.println("ResourceBean:-----release resource, do some cleaning work");
		try{
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public FileOutputStream getFos() {
		return fos;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
}
