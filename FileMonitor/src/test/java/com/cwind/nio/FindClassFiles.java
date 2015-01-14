package com.cwind.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FindClassFiles {
	public static void main(String[] args) throws IOException {
		Path dir = Paths.get("E:\\SourceCodes\\GitHub\\BillyChen\\CwindJavaLab\\FileMonitor");
		Files.walkFileTree(dir, new FindClassVisitor());
	}
	
	private static class FindClassVisitor extends SimpleFileVisitor<Path> {
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
			if(file.toString().endsWith(".class")) {
				System.out.println(file.getFileName());
			}
			return FileVisitResult.CONTINUE;
		}
	}
}
