package Thread.ZeroEvenOdd.lock;

public class Test {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(9);
        ThreadZero threadZero = new ThreadZero(zeroEvenOdd);
        ThreadEven threadEven = new ThreadEven(zeroEvenOdd);
        ThreadOdd threadOdd = new ThreadOdd(zeroEvenOdd);
        Thread thread1 = new Thread(threadZero);
        Thread thread2 = new Thread(threadEven);
        Thread thread3 = new Thread(threadOdd);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
