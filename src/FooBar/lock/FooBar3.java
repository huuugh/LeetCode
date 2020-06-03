package Thread.FooBar.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar3 {
    int n = 10;

    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition1 = reentrantLock.newCondition();
    Condition condition2 = reentrantLock.newCondition();
    private Integer count = 1;

    public void foo() {
        for (int i = 0; i < n; i++) {
            reentrantLock.lock();
            if (count != 1) {
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("foo");
            count = 2;
            condition2.signal();
//            if (i == n - 1) {
//                Thread.currentThread().interrupt();
//            }
//            if (Thread.currentThread().isInterrupted()) {
//
//            }
            reentrantLock.unlock();
        }
    }

    public void bar() {
        for (int i = 0; i < n; i++) {
            reentrantLock.lock();
            if (count != 2) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("bar");
            count = 1;
            condition1.signal();
//            if (i == n - 1) {
//                Thread.currentThread().interrupt();
//            }
//            if (Thread.currentThread().isInterrupted()) {
//
//            }
            reentrantLock.unlock();
        }
    }
}
