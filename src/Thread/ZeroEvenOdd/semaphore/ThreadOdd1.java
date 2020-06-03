package Thread.ZeroEvenOdd.semaphore;

import Thread.ZeroEvenOdd.lock.ZeroEvenOdd;

import java.util.function.IntConsumer;

public class ThreadOdd1 implements Runnable {

    private final ZeroEvenOdd1 zeroEvenOdd;

    public ThreadOdd1(ZeroEvenOdd1 zeroEvenOdd) {
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        try {
            zeroEvenOdd.odd(new IntConsumer() {
                @Override
                public void accept(int value) {
                    System.out.print(value);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
