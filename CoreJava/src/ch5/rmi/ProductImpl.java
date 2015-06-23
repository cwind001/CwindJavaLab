package ch5.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 6/23/2015
 * Email: billchen01@163.com
 */
public class ProductImpl extends UnicastRemoteObject implements Product{

    private String name;

    public ProductImpl(String n) throws RemoteException{
        this.name = n;
    }

    @Override
    public String getDescription() throws RemoteException {
        return "I am a " + name + ". Buy me!";
    }
}
