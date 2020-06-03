package Thread.FizzBuzz;

public class FizzThread implements Runnable {

    private final FizzBuzz fizzBuzz;

    public FizzThread(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    @Override
    public void run() {
        try {
            fizzBuzz.fizz(new Runnable() {
                @Override
                public void run() {

                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
