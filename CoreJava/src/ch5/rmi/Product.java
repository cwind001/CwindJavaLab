package ch5.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 6/23/2015
 * Email: billchen01@163.com
 */
public interface Product extends Remote {
    String getDescription() throws RemoteException;
}
