package Thread.FooBar.sema;

public class ThreadC implements Runnable {

    private final FooBar2 fooBar;

    public ThreadC(FooBar2 fooBar) {
        this.fooBar = fooBar;
    }

    @Override
    public void run() {
        fooBar.foo();
    }
}
