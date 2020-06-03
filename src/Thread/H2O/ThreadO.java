package Thread.H2O;

public class ThreadO implements Runnable {
    private final H2O h2O;

    public ThreadO(H2O h2O) {
        this.h2O = h2O;
    }

    @Override
    public void run() {
            try {
                h2O.oxygen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
