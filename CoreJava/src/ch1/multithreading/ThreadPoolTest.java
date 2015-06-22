package ch1.multithreading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/20
 * Email: billchen01@163.com
 */

public class ThreadPoolTest {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
        String directory = in.nextLine();
        System.out.print("Enter keyword (e.g. volatile): ");
        String keyword = in.nextLine();

        ExecutorService pool = Executors.newCachedThreadPool();

        MatchCounter2 counter = new MatchCounter2(new File(directory), keyword, pool);
        Future<Integer> result = pool.submit(counter);

        try {
            System.out.println(result.get() + " matching files");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();

        int largetPoolSize = ((ThreadPoolExecutor)pool).getPoolSize();
        System.out.println("largest pool size: "+ largetPoolSize);
    }

}

class MatchCounter2 implements Callable<Integer> {

    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter2(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try{
            File[] files = directory.listFiles();
            ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();

            for(File file : files){
                if(file.isDirectory()){
                    MatchCounter2 counter = new MatchCounter2(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }else{
                    if(search(file)){
                        count++;
                    }
                }
            }

            for(Future<Integer> result : results){
                try{
                    count += result.get();
                }catch (ExecutionException e){
                    e.printStackTrace();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return count;
    }

    public boolean search(File file) {
        try {
            Scanner in = new Scanner(new FileInputStream(file));
            boolean found = false;
            while (!found && in.hasNextLine()){
                String line = in.nextLine();
                if(line.contains(keyword)){
                    found = true;
                }
            }
            in.close();
            return found;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
