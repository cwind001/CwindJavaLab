package ch5.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/23
 * Email: billchen01@163.com
 */
public interface Warehouse extends Remote {

    ArrayList<Product> find(Customer c) throws RemoteException;
}
