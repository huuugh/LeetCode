package Thread.FooBar.synch;

public class ThreadA implements Runnable {

    private final FooBar fooBar;

    public ThreadA(FooBar fooBar) {
        this.fooBar = fooBar;
    }

    @Override
    public void run() {
        fooBar.foo();
    }
}
