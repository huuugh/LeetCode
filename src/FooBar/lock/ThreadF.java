package Thread.FooBar.lock;

import Thread.FooBar.synch.FooBar;

public class ThreadF implements Runnable {
    private final FooBar3 fooBar;

    public ThreadF(FooBar3 fooBar) {
        this.fooBar = fooBar;
    }

    @Override
    public void run() {
        fooBar.bar();
    }
}
