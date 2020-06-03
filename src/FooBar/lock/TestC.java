package Thread.FooBar.lock;

import Thread.FooBar.synch.FooBar;
import Thread.FooBar.synch.ThreadA;
import Thread.FooBar.synch.ThreadB;

public class TestC {

    public static void main(String[] args) {
        FooBar3 fooBar = new FooBar3();
        ThreadE threadE = new ThreadE(fooBar);
        ThreadF threadF = new ThreadF(fooBar);
        Thread threadEE = new Thread(threadE);
        Thread threadFF = new Thread(threadF);
        threadEE.start();
        threadFF.start();
    }
}
