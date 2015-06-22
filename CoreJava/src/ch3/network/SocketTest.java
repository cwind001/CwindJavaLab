package ch3.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/22
 * Email: billchen01@163.com
 */
public class SocketTest {

    public static void main(String[] args){
        try{
            Socket s = new Socket("127.0.0.1", 8189);
            try{
                InputStream inStream = s.getInputStream();
                Scanner in = new Scanner(inStream);

                while (in.hasNextLine()){
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }finally {
                s.close();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
