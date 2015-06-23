package ch5.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 6/23/2015
 * Email: billchen01@163.com
 */
public class ProductServer {
    public static void main(String[] args){
        System.out.println("Constructing server implementations...");
        try {
            LocateRegistry.createRegistry(6600);
            ProductImpl p1 = new ProductImpl("Blackwell Toaster");
            ProductImpl p2 = new ProductImpl("ZapXpress Microwave Oven");

            System.out.println("Binding server implementatioins to registry...");
            Context namingContext = new InitialContext();
            namingContext.rebind("rmi://127.0.0.1:6600/toaster", p1);
            namingContext.rebind("rmi://127.0.0.1:6600/microwave", p2);
            System.out.println("Waiting for invocations from clients...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
