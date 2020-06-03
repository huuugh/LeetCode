package Thread.FooBar.synch;

import Thread.FooBar.sema.FooBar2;
import Thread.FooBar.sema.ThreadC;
import Thread.FooBar.sema.ThreadD;

public class TestA {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar();
        ThreadA threadA = new ThreadA(fooBar);
        ThreadB threadB = new ThreadB(fooBar);
        Thread threadAA = new Thread(threadA);
        Thread threadBB = new Thread(threadB);
        threadAA.start();
        threadBB.start();
    }
}
