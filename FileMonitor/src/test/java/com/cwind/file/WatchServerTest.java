package com.cwind.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServerTest {
	public static void main(String[] args) throws InterruptedException, IOException {
		WatchService watchService = FileSystems.getDefault().newWatchService();
		final Path path = Paths.get(".");
		final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, 
				StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
		boolean fileNotChanged = true;
		int count = 0;
		while (fileNotChanged) {
			final WatchKey wk = watchService.take();
		    System.out.println("Loop count: " + count);
		    for (WatchEvent<?> event : wk.pollEvents()) {
		        //we only register "ENTRY_MODIFY" so the context is always a Path.
		        final Path changed = (Path) event.context();
		        System.out.println(changed + ", " + event.kind());
		        if (changed.endsWith("sample1.txt")) {
		            System.out.println("Sample file has changed");
		        }
		    }
		    // reset the key
		    boolean valid = wk.reset();
		    if (!valid) {
		        System.out.println("Key has been unregisterede");
		    }
		    count++;
		}
	}
}
