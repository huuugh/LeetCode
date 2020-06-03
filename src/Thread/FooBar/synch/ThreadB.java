package Thread.FooBar.synch;

public class ThreadB implements Runnable {
    private final FooBar fooBar;

    public ThreadB(FooBar fooBar) {
        this.fooBar = fooBar;
    }

    @Override
    public void run() {
        fooBar.bar();
    }
}
