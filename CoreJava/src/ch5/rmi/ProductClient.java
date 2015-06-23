package ch5.rmi;

import javax.naming.InitialContext;
import java.rmi.RMISecurityManager;
import javax.naming.Context;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 6/23/2015
 * Email: billchen01@163.com
 */

public class ProductClient {
    public static void main(String[] args){
        System.setProperty("java.security.policy", "E:\\SourceCodes\\GitHub\\BillyChen\\CwindJavaLab\\CoreJava\\src\\ch5\\rmi\\client.policy");
        System.setSecurityManager(new RMISecurityManager());
        String url = "rmi://127.0.0.1:6600/";

        try{
            Context namingContext = new InitialContext();
            Product c1 = (Product) namingContext.lookup(url + "toaster");
            Product c2 = (Product) namingContext.lookup(url + "microwave");

            System.out.println(c1.getDescription());
            System.out.println(c2.getDescription());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
