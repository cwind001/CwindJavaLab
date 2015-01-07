package com.cwind.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class FileChangeMonitor {

	public static final long DELAY_TIME = 1000;
	
	private static FileChangeMonitor monitor;

	private Map<String, List<TimerTask>> fileObservers;
	private Timer timer;

	private FileChangeMonitor()
	{
		fileObservers = Collections.synchronizedMap(new Hashtable<String, List<TimerTask>>());
		timer = new Timer(FileChangeMonitor.class.getName());
	}

	public synchronized static FileChangeMonitor getInstance()
	{
		if (monitor == null)
			monitor = new FileChangeMonitor();
		return monitor;
	}

	public void addObserver(FileChangeObserver observer, String filename, long delay) throws FileNotFoundException
	{
		TimerTask task = new FileChangeTask(observer, filename);
		List<TimerTask> tasks = fileObservers.get(filename);
		if(tasks==null){
			tasks = new ArrayList<TimerTask>();
		}
		tasks.add(task);
		fileObservers.put(filename, tasks);
		timer.schedule(task, delay, delay);
	}

	private static class FileChangeTask extends TimerTask
	{
		private FileChangeObserver observer;
		private File file;
		private long lastModified;

		public FileChangeTask(FileChangeObserver observer, String filename) throws FileNotFoundException
		{
			super();
			this.observer = observer;
			this.file = new File(filename);
			if (!this.file.exists())
				throw new FileNotFoundException("FileChangeMonitor.FileChangeTask() Can't locate:" + filename);
			this.lastModified = file.lastModified();
		}

		public void run()
		{
			try
			{
				long newLastModified = file.lastModified();
				if (newLastModified > lastModified)
				{
					lastModified = newLastModified;
					observer.fileChanged(file.getPath());
				}
			}
			catch (Exception e)	{
				System.err.println(e.getMessage());
			}
		}
	}
}
