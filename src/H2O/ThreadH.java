package Thread.H2O;

public class ThreadH implements Runnable {
    private final H2O h2O;

    public ThreadH(H2O h2O) {
        this.h2O = h2O;
    }

    @Override
    public void run() {
            try {
                h2O.hydrogen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
