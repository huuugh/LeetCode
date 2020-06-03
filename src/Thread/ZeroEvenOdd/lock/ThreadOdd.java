package Thread.ZeroEvenOdd.lock;

import java.util.function.IntConsumer;

public class ThreadOdd implements Runnable {

    private final ZeroEvenOdd zeroEvenOdd;

    public ThreadOdd(ZeroEvenOdd zeroEvenOdd) {
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
