package Thread.ZeroEvenOdd.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private volatile int start = 1;
    private volatile int who;
    private Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (start <= n) {
            if (who != 0) {
                zero.await();
            } else {
                printNumber.accept(0);
                if (start % 2 == 0) {
                    who = 2;
                    even.signal();
                } else {
                    who = 1;
                    odd.signal();
                }
            }
        }
        zero.await();
        lock.unlock();
    }

    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (start<=n){
            if (who != 2){
                even.await();
            }else {
                printNumber.accept(start++);
                who = 0;
                zero.signal();
            }
        }
        lock.unlock();
    }

    //奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (start<=n){
            if (who != 1){
                odd.await();
            }else {
                printNumber.accept(start++);
                who = 0;
                zero.signal();
            }
        }
        lock.unlock();
    }
}
