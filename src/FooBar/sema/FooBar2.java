package Thread.FooBar.sema;

import java.util.concurrent.Semaphore;

public class FooBar2 {
    int n = 10;

    private volatile int count1 = 0, count2 = 0;
    private final Semaphore semaphore1;
    private final Semaphore semaphore2;

    public FooBar2() {
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(0);
    }

    public void foo() {
        for (int i = 0; i < n; i++) {
            try {
                semaphore1.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("foo");
            semaphore2.release();
            if (count1 == n - 1) {
                Thread.currentThread().interrupt();
            }
            if (Thread.currentThread().isInterrupted()) {

            }
        }
    }

    public void bar() {
        for (int i = 0; i < n; i++) {
            try {
                semaphore2.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("bar");
            semaphore1.release();
            if (count1 == n - 1) {
                Thread.currentThread().interrupt();
            }
            if (Thread.currentThread().isInterrupted()) {

            }
        }
    }
}
