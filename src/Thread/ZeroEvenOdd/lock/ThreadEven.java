package Thread.ZeroEvenOdd.lock;

import java.util.function.IntConsumer;

public class ThreadEven implements Runnable {

    private final ZeroEvenOdd zeroEvenOdd;

    public ThreadEven(ZeroEvenOdd zeroEvenOdd) {
        this.zeroEvenOdd = zeroEvenOdd;
    }

    @Override
    public void run() {
        try {
            zeroEvenOdd.even(new IntConsumer() {
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
