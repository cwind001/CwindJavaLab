package ch1.multithreading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/20
 * Email: billchen01@163.com
 */

public class FutureTest {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
        String directory = in.nextLine();
        System.out.print("Enter keyword (e.g. volatile): ");
        String keyword = in.nextLine();

        MatchCounter counter = new MatchCounter(new File(directory), keyword);
        FutureTask<Integer> task = new FutureTask<Integer>(counter);

        Thread t = new Thread(task);
        t.start();
        try{
            System.out.println(task.get() + " matching files.");
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private int count;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    public Integer call() {
        count = 0;
        try {
            File[] files = directory.listFiles();
            ArrayList<FutureTask<Integer>> results = new ArrayList<FutureTask<Integer>>();

            for(File file : files) {
                if(file.isDirectory()){
                    MatchCounter counter = new MatchCounter(file, keyword);
                    FutureTask<Integer> task = new FutureTask<Integer>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
                }else {
                    if(search(file)){
                        count++;
                    }
                }
            }

            for(Future<Integer> result : results){
                try{
                    count += result.get();
                }catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return count;
    }

    public boolean search(File file) {
        try{
            Scanner in = new Scanner(new FileInputStream(file));
            boolean found = false;
            while(!found && in.hasNextLine()){
                String line = in.nextLine();
                if(line.contains(keyword)){
                    return true;
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


