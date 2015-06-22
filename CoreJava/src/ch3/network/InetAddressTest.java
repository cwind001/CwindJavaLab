package ch3.network;

import java.net.InetAddress;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/22
 * Email: billchen01@163.com
 */
public class InetAddressTest {
    public static void main(String[] args){
        try{
            if(args.length > 0) {
                String host = args[0];
                InetAddress[] addresses = InetAddress.getAllByName(host);
                for(InetAddress a : addresses){
                    System.out.println(a);
                }
            } else {
                InetAddress localHostAddress = InetAddress.getLocalHost();
                System.out.println(localHostAddress);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
