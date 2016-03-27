package com.cwind.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by Cwind on 2016/3/27.
 */
public class TestTask implements Runnable{
    private String name;

    public TestTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing task - " + name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
