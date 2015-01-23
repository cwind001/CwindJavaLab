package com.cwind.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TWRReadWriteFiles {
	public static void main(String[] args) { 
		Path file = Paths.get(".\\src\\test\\java\\com\\cwind\\nio\\TWRReadWriteFiles.java");
		try(BufferedReader reader = Files.newBufferedReader(file)){
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
