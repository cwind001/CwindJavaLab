package ch3.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 6/22/15
 * Time: 10:39 AM
 * Email: billchen01@163.com
 */
public class EchoServer {
    public static void main(String[] args){
        try{
            ServerSocket s = new ServerSocket(8189);
            Socket incoming = s.accept();
            try{
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();

                Scanner in = new Scanner(inputStream);
                PrintWriter out = new PrintWriter(outputStream, true);

                out.println("Hello! Enter BYE to exit.");

                boolean done = false;
                while (!done && in.hasNextLine()){
                    String line = in.nextLine();
                    out.println("Echo: "+ line);
                    if(line.trim().equals("BYE")){
                        done = true;
                    }

                }
            }finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
