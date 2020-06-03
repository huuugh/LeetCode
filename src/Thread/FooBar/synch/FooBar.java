package Thread.FooBar.synch;

public class FooBar {
    int n = 100;

    private int count = 1;

    public void foo() {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (count == 1) {
                    System.out.print("foo");
                    count = 2;
                    this.notify();
                }
                if (i == n - 1) {
                    Thread.currentThread().interrupt();
                }
                if (Thread.currentThread().isInterrupted()) {

                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void bar() {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (count == 2) {
                    System.out.print("bar");
                    count = 1;
                    this.notify();
                }
                if (i == n - 1) {
                    Thread.currentThread().interrupt();
                }
                if (Thread.currentThread().isInterrupted()) {

                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
