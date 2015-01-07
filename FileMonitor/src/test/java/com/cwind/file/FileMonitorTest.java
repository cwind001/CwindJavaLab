package com.cwind.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileMonitorTest {
	
	File sampleFile1, sampleFile2;
	FileChangeMonitor monitor;
	ConsoleFileChangeObserver consoleObserver;
	EmailFileChangeObserver emailObserver;
	
	@Before
	public void setUp() throws Exception {
		sampleFile1 = new File("sample1.txt"); 
		sampleFile2 = new File("sample2.txt");
		monitor = FileChangeMonitor.getInstance();
		consoleObserver = new ConsoleFileChangeObserver();
		emailObserver = new EmailFileChangeObserver("billchen01@163.com");
	}

	@After
	public void tearDown() throws Exception	{
		
	}
	
	@Test
	public void testMonitorSampleFile() throws InterruptedException, IOException{
		monitor.addObserver(consoleObserver, sampleFile1.getPath(), FileChangeMonitor.DELAY_TIME);
		monitor.addObserver(emailObserver, sampleFile1.getPath(), FileChangeMonitor.DELAY_TIME);
		monitor.addObserver(consoleObserver, sampleFile2.getPath(), FileChangeMonitor.DELAY_TIME);
		
		FileOutputStream fos1 = new FileOutputStream(sampleFile1);
		FileOutputStream fos2 = new FileOutputStream(sampleFile2);
		fos1.write(0);
		fos2.write(0);
		fos1.flush();
		fos2.flush();
		fos1.close();
		fos2.close();
		Thread.sleep(3000);
	}
}
