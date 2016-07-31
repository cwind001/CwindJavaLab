package com.cwind.string;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Stay hungry, stay foolish.
 * Author: Cwind
 * Date: 2016/7/31
 * Description:
 */
public class StringBufferAndStringBuilderTest {

    private static final int THREAD_NUM = 1000;

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);

        for(int i=0; i<THREAD_NUM; i++) {
            new StringBufferTaskThread(stringBuffer, stringBuilder, countDownLatch).start();
        }

        try {
            countDownLatch.await();
            System.out.println("StringBuffer toString: " + stringBuffer.toString());
            System.out.println("StringBuilder toString: " + stringBuilder.toString());
            long endTime = System.currentTimeMillis();
            System.out.println("Running time: " + (endTime-startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class StringBufferTaskThread extends Thread {
    private static final String STARTER = "-start";
    private static final String ENDER = "-end";

    private StringBuffer stringBuffer;
    private StringBuilder stringBuilder;
    private CountDownLatch countDownLatch;  // 记载运行线程数

    public StringBufferTaskThread(StringBuffer stringBuffer, StringBuilder stringBuilder, CountDownLatch countDownLatch) {
        super();
        this.stringBuffer = stringBuffer;
        this.stringBuilder = stringBuilder;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + STARTER);
        for(int i=0; i<10; i++) {
            if(i == 5){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stringBuilder.append(i);
//            stringBuffer.append(i);
        }
        System.out.println(Thread.currentThread().getName() + ENDER);
        countDownLatch.countDown();
    }
}
