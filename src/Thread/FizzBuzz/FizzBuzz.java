package Thread.FizzBuzz;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(0);
    Semaphore s4 = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i=3;i<=n;i+=3){
            s2.acquire();
            printFizz.run();
            s1.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i=5;i<=n;i+=5){
            s3.acquire();
            printBuzz.run();
            s1.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i=15;i<=n;i+=15){
            s4.acquire();
            printFizzBuzz.run();
            s1.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            s1.acquire();
            if(i%3==0 && i%5==0){
                s4.release();
            }else if(i%3==0){
                s2.release();
            }else
            if(i%5==0){
                s3.release();
            }else{
                printNumber.accept(i);
                s1.release();
            }
        }
    }
}
