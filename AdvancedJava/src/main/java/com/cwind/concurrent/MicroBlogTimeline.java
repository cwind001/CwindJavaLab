package com.cwind.concurrent;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class MicroBlogTimeline {
	private final CopyOnWriteArrayList<Update> updates;
	private final ReentrantLock lock;
	private final String name;
	private Iterator<Update> it;
	
	public MicroBlogTimeline() {
		this.updates = new CopyOnWriteArrayList<>();
		this.lock = new ReentrantLock();
		this.name = "Default Name";
	}
	
	public MicroBlogTimeline(String name, CopyOnWriteArrayList<Update> updates,
			ReentrantLock lock) {
		super();
		this.updates = updates;
		this.lock = lock;
		this.name = name;
	}

	public void addUpdate(Update update_) {
		updates.add(update_);
	}
	
	public void prep() {
		it = updates.iterator();
	}
	
	public void printTimeline() {
		lock.lock();
		try {
			if(it!=null){
				System.out.print(name + ": ");
				while (it.hasNext()) {
					Update s = it.next();
					System.out.println(s+ ", ");
				}
			}
		} finally {
			lock.unlock();
		}
	}
}
