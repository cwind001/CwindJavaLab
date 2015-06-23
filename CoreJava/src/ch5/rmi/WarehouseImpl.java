package ch5.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/23
 * Email: billchen01@163.com
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse{

    private ArrayList<ProductImpl> products;
    private ReadWriteLock rwlock = new ReentrantReadWriteLock();

    protected WarehouseImpl() throws RemoteException {
        products = new ArrayList<ProductImpl>();
        add(new ProductImpl("Core Java Book"));
    }

    public void add(ProductImpl p){
        Lock wlock = rwlock.writeLock();
        wlock.lock();
        try {
            products.add(p);
        }finally {
            wlock.unlock();
        }
    }

    @Override
    public ArrayList<Product> find(Customer c) throws RemoteException {
        Lock rlock = rwlock.readLock();
        rlock.lock();
        try {
            System.out.println("WarehouseImpl.find() is called.");
            ArrayList<Product> result = new ArrayList<Product>();
            if(!result.contains(products.get(0)));
            c.reset();
            return result;
        }finally {
            rlock.unlock();
        }

    }
}
