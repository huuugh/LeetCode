package Thread.ZeroEvenOdd.semaphore;

import Thread.ZeroEvenOdd.lock.ZeroEvenOdd;

import java.util.function.IntConsumer;

public class ThreadZero1 implements Runnable {

    private final ZeroEvenOdd1 zeroEvenOdd;

    public ThreadZero1(ZeroEvenOdd1 zeroEvenOdd) {
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        try {
            zeroEvenOdd.zero(new IntConsumer() {
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
