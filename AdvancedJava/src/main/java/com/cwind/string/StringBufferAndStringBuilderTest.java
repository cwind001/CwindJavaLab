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
        String strToReverse = "####$$$$";

        StringBuffer stringBuffer = new StringBuffer(strToReverse);
        StringBuilder stringBuilder = new StringBuilder(strToReverse);
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);
        CountDownLatch countDownLatch2 = new CountDownLatch(THREAD_NUM);

        for(int i=0; i<THREAD_NUM; i++) {
            new StringBufferTaskThread(stringBuilder, countDownLatch).start();
            new StringBufferTaskThread(stringBuffer, countDownLatch2).start();
        }

        try {
            countDownLatch.await();
            countDownLatch2.await();
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

    private Object s = null;
    private CountDownLatch countDownLatch;  // 记载运行线程数

    public StringBufferTaskThread(StringBuilder stringBuilder, CountDownLatch countDownLatch) {
        super();
        this.s = stringBuilder;
        this.countDownLatch = countDownLatch;
    }

    public StringBufferTaskThread(StringBuffer stringBuffer, CountDownLatch countDownLatch) {
        super();
        this.s = stringBuffer;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + STARTER);
        for(int i=0; i<10; i++) {
            try {
                Thread.sleep(200);
                if(s instanceof StringBuffer){
                    ((StringBuffer) s).reverse();
                    System.out.println("Buffer->"+s.toString());
                }else if(s instanceof StringBuilder){
                    ((StringBuilder) s).reverse();
                    System.out.println("Builder->"+s.toString());
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ENDER);
        countDownLatch.countDown();
    }
}
