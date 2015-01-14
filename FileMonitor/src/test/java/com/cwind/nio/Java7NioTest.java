package com.cwind.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Java7NioTest {
	public static void main(String[] args) {
		Path currentPath = Paths.get("E:\\SourceCodes\\GitHub\\BillyChen\\CwindJavaLab\\FileMonitor");
		System.out.println("File Name [" + currentPath.getFileName() + "]");
		System.out.println("Number of Name Elements in the Path [" + currentPath.getNameCount() + "]");
		System.out.println("Parent Path [" + currentPath.getParent() + "]");
		System.out.println("Root of Path [" + currentPath.getRoot() + "]");
		System.out.println("Subpath from Root, 2 elements deep [" + currentPath.subpath(0, 2) + "]");
	}
}
