package com.cwind.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

import com.cwind.multithreading.microblog.Author;
import com.cwind.multithreading.microblog.MicroBlogTimeline;
import com.cwind.multithreading.microblog.Update;

public class TestMicroBlogTimeline {
	public static void main(String[] args) {
		final CountDownLatch firstLatch = new CountDownLatch(1);
		final CountDownLatch secondLatch = new CountDownLatch(1);
		final Update.Builder ub = new Update.Builder();
		
		final CopyOnWriteArrayList<Update> list = new CopyOnWriteArrayList<>();
		list.add(ub.author(new Author("Bill")).updateText("Heroes of the Storm").build());
		list.add(ub.author(new Author("Lily")).updateText("I enjoy cooking").build());
		
		ReentrantLock lock = new ReentrantLock();
		final MicroBlogTimeline tl1 = new MicroBlogTimeline("TL1", list, lock);
		final MicroBlogTimeline tl2 = new MicroBlogTimeline("TL2", list, lock);
		
		Thread t1 = new Thread() {
			public void run() {
				list.add(ub.author(new Author("Tom")).updateText("I like Jerry.").build());
				tl1.prep();
				firstLatch.countDown();
				try {
					secondLatch.await();
				}catch (InterruptedException e){
					
				}
				tl1.printTimeline();
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				try {
					firstLatch.await();
					list.add(ub.author(new Author("Jerry")).updateText("I dislike Tom.").build());
					tl2.prep();
					secondLatch.countDown();
				}catch (InterruptedException e){
					
				}
				tl2.printTimeline();
			}
		};
		
		t1.start();
		t2.start();
	}
}
