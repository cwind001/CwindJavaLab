package ch1.multithreading;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/20
 * Email: billchen01@163.com
 */

public class SynchBankTest2 {
    public static void main(String[] args){
        Bank2 b2 = new Bank2(NACCOUNTS, INITIAL_BALANCE);
        int i;
        for(i=0; i<NACCOUNTS; i++){
            TransferRunnable2 r2 = new TransferRunnable2(b2, i, INITIAL_BALANCE);
            Thread t = new Thread(r2);
            t.start();
        }
    }

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
}

class Bank2{
    public Bank2(int n, double initBalance){
        accounts = new double[n];
        for(int i=0; i<n; i++){
            accounts[i] = initBalance;
        }
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) wait();
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d ", amount, from, to);
        accounts[to] += amount;
        System.out.printf("Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    public synchronized double getTotalBalance(){
        double sum = 0;

        for (double a : accounts){
            sum += a;
        }

        return sum;
    }

    public int size() {
        return accounts.length;
    }

    private final double[] accounts;
}

class TransferRunnable2 implements Runnable{

    private Bank2 bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    public TransferRunnable2(Bank2 b2, int f, double maxAmount){
        this.bank = b2;
        this.fromAccount = f;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {
        try{
            while (true){
                int toAccount = (int) (bank.size() * Math.random());
                double amount = maxAmount * Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep((long) (DELAY*Math.random()));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}