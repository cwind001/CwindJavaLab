package com.cwind.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.WatchService;

public class WatchServerTest {
	public static void main(String[] args) throws IOException {
		File sampleFile1 = new File("sample1.txt");
		WatchService watchService = FileSystems.getDefault().newWatchService();
	}
}
