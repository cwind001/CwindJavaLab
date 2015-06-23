package ch5.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/23
 * Email: billchen01@163.com
 */
public class WarehouseServer {
    public static void main(String[] args){
        try{
            System.out.println("Constructing server implementations...");
            WarehouseImpl w = new WarehouseImpl();
            w.add(new ProductImpl("Blackwell Toaster"));
            w.add(new ProductImpl("ZapXpress Microwave Oven"));
            w.add(new ProductImpl("DirtDigger Steam Shovel"));
            w.add(new ProductImpl("U238 Weed Killer"));
            w.add(new ProductImpl("Persistent Java Fragrance"));
            w.add(new ProductImpl("Rabid Rodent Computer Mouse"));
            w.add(new ProductImpl("My first Espresso Maker"));
            w.add(new ProductImpl("JavaJungle Eau de Cologne"));
            w.add(new ProductImpl("FireWire Espresso Maker"));
            w.add(new ProductImpl("Learn Bad Java Habits in 21 Days Book"));

            System.out.println("Binding server implementations to registry...");
            LocateRegistry.createRegistry(6600);
            Context namingContext = new InitialContext();
            namingContext.rebind("rmi://127.0.0.1:6600/warehouse", w);
            System.out.println("Waiting for invocations from clients...");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
