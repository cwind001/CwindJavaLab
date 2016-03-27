package com.cwind.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Cwind on 2016/3/27.
 */
public class BasicThreadPoolExecutorTest {

    public static void main(String[] args){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for(int i=0; i < 5; i++) {
            TestTask task = new TestTask("Test task " + i);
            System.out.println("Adding Test task " + i);
            executor.execute(task);
        }
        executor.shutdown();
    }
}
