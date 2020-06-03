package Thread.ZeroEvenOdd.semaphore;


public class Test {
    public static void main(String[] args) {
        ZeroEvenOdd1 zeroEvenOdd = new ZeroEvenOdd1(5);
        ThreadZero1 threadZero = new ThreadZero1(zeroEvenOdd);
        ThreadEven1 threadEven = new ThreadEven1(zeroEvenOdd);
        ThreadOdd1 threadOdd = new ThreadOdd1(zeroEvenOdd);
        Thread thread1 = new Thread(threadZero);
        Thread thread2 = new Thread(threadEven);
        Thread thread3 = new Thread(threadOdd);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
