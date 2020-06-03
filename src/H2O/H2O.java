package Thread.H2O;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {

    private int h2o = 0;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition conditionH = reentrantLock.newCondition();
    Condition conditionO = reentrantLock.newCondition();

    public H2O() {

    }

    public void hydrogen() throws InterruptedException {
        reentrantLock.lock();
        while ((h2o & 3) == 3) {
            conditionH.await();
        }
        System.out.print("H");
        h2o += (h2o & 3) == 0 ? 1 : 2;
        if ((h2o & 3) != 3){
            conditionH.signal();
        }
        if (h2o==7){
            h2o=0;
        }
        conditionO.signal();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        reentrantLock.unlock();
    }

    public void oxygen() throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        System.out.print("O");
    }
}
