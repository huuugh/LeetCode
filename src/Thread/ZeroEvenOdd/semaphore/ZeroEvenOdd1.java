package Thread.ZeroEvenOdd.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd1 {
    private int n;
    private Semaphore semaphoreZero = new Semaphore(1);
    private Semaphore semaphoreEven = new Semaphore(0);
    private Semaphore semaphoreOdd = new Semaphore(0);

    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            if (i%2==0){
                semaphoreEven.release();
            }else {
                semaphoreOdd.release();
            }
        }
    }

    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            semaphoreEven.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }

    //奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            semaphoreOdd.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }
}
