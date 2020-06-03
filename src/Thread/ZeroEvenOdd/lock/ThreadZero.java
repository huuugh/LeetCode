package Thread.ZeroEvenOdd.lock;

import java.util.function.IntConsumer;

public class ThreadZero implements Runnable {

    private final ZeroEvenOdd zeroEvenOdd;

    public ThreadZero(ZeroEvenOdd zeroEvenOdd) {
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
