package Thread.FooBar.sema;

public class ThreadD implements Runnable {

    private final FooBar2 fooBar;

    public ThreadD(FooBar2 fooBar) {
        this.fooBar = fooBar;
    }

    @Override
    public void run() {
        fooBar.bar();
    }
}
