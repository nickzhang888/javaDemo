import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private Lock lock;

    public BankAccount(double balance) {
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        lock.lock(); // 获取悲观锁
        try {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public void withdraw(double amount) {
        lock.lock(); // 获取悲观锁
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance!");
            }
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public double getBalance() {
        return balance;
    }
}
