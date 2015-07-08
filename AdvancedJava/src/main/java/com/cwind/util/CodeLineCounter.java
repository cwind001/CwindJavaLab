package com.cwind.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeLineCounter {
	static long normalLine = 0;
	static long commentLine = 0;
	static long whiteLine = 0;

	public static void countCodeLine(File rootDir){
		File[] files = rootDir.listFiles();
		for(File file : files){
			if(file.isDirectory()){
				countCodeLine(file);
			}else if(file.getName().endsWith(".java")){
				BufferedReader br = null;
				boolean bln = false;
				try{
					br = new BufferedReader(new FileReader(file));
					String line = "";
					try{
						while((line=br.readLine()) != null) {
							line = line.trim();
							if(line.matches("^[\\s&&[^\\n]]*$")){
								whiteLine+=1;
							}else if(line.startsWith("/*")&&!line.endsWith("*/")){
								commentLine+=1;
								bln = true;
							}else if(bln){
								commentLine+=1;
								if(line.endsWith("*/")){
									bln=false;
								}
							}else if(line.startsWith("/*")&&line.endsWith("*/")){
								commentLine+=1;
							}else if(line.startsWith("//")){
								commentLine+=1;
							}else{
								normalLine+=1;
							}
						}
					}catch(IOException e){
						e.printStackTrace();
					}
					
				}catch(FileNotFoundException e){
					e.printStackTrace();
				}finally{
					if(br!=null){
						try{
							br.close();
							br=null;
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	
	
	public static void main(String[] args){
		String springcore = "E:\\SourceCode\\Github\\References\\spring-framework\\spring-core";
		String springaop = "E:\\SourceCode\\Github\\References\\spring-framework\\spring-aop";
		String ehcached3 = "E:\\SourceCode\\Github\\References\\ehcache3";
		String netty = "E:\\SourceCode\\Github\\References\\netty";
		
		String designpatterns = "E:\\SourceCode\\Github\\java-design-patterns";
		String cwindjavalab = "E:\\SourceCode\\Github\\CwindJavaLab";
		String familybilling = "E:\\SourceCode\\LunaWorkspace\\FamilyBilling";
		
		File rootDir = new File(netty);
		countCodeLine(rootDir);

		System.out.println("有效行数： "+normalLine);
		System.out.println("注释行数： "+commentLine);
		System.out.println("空白行数： "+whiteLine);
	}
}
