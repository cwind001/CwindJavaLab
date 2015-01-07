package com.cwind.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServerTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		File sampleFile1 = new File("sample1.txt");
		String absolutePath = sampleFile1.getAbsolutePath();
		absolutePath = absolutePath.substring(0, absolutePath.lastIndexOf("\\"));
		WatchService watchService = FileSystems.getDefault().newWatchService();
		final Path path = FileSystems.getDefault().getPath(absolutePath);
		System.out.println(path);
		final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		while (true) {
		    final WatchKey wk = watchService.take();
		    for (WatchEvent<?> event : wk.pollEvents()) {
		        //we only register "ENTRY_MODIFY" so the context is always a Path.
		        final Path changed = (Path) event.context();
		        System.out.println(changed);
		        if (changed.endsWith(sampleFile1.getName())) {
		            System.out.println("Sample file has changed");
		        }
		    }
		    // reset the key
		    boolean valid = wk.reset();
		    if (!valid) {
		        System.out.println("Key has been unregisterede");
		    }
		}
	}
}
