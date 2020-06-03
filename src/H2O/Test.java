package Thread.H2O;

public class Test {
    public static void main(String[] args) {
        H2O h2O = new H2O();
        ThreadH threadH = new ThreadH(h2O);
        ThreadO threadO = new ThreadO(h2O);
        Thread thread1 = new Thread(threadH);
        Thread thread2 = new Thread(threadH);
        Thread thread3 = new Thread(threadH);
        Thread thread4 = new Thread(threadH);

        Thread thread5 = new Thread(threadO);
        Thread thread6 = new Thread(threadO);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
