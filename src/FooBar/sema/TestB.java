package Thread.FooBar.sema;

public class TestB {
    public static void main(String[] args) {
        FooBar2 fooBar2 = new FooBar2();
        ThreadC threadC = new ThreadC(fooBar2);
        ThreadD threadD = new ThreadD(fooBar2);
        Thread threadCC = new Thread(threadC);
        Thread threadDD = new Thread(threadD);
        threadCC.start();
        threadDD.start();
    }
}
