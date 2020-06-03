package Thread.FooBar.lock;

import Thread.FooBar.synch.FooBar;

public class ThreadE implements Runnable {

    private final FooBar3 fooBar;

    public ThreadE(FooBar3 fooBar) {
        this.fooBar = fooBar;
    }

    @Override
    public void run() {
        fooBar.foo();
    }
}
