package library.threads;

/**
 * Created by anatarajan on 1/12/16.
 */
public class EvenOdd {
    public static void main(String[] args) {
        State lock = new State();
        new Thread(new EvenThread(lock)).start();
        new Thread(new OddThread(lock)).start();
    }
}

class State {
    boolean condition = true;

    public boolean getFlag() {
        return condition;
    }

    public void setFlag(boolean flag) {
        this.condition = flag;
    }
}

class EvenThread implements Runnable {
    private State lock;

    public EvenThread(State lock) {
        this.lock = lock;
    }

    public void run() {
        for (int i = 0; i < 10; i += 2) {
            synchronized (lock) {
                System.out.println(i);
                while (lock.getFlag()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ie) {

                    }
                }
                lock.setFlag(true);
                lock.notify();
            }
        }
    }
}

class OddThread implements Runnable {
    private State lock;

    public OddThread(State lock) {
        this.lock = lock;
    }
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            synchronized (lock) {

                while (!lock.getFlag()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {

                    }
                }
                System.out.println(i);
                lock.setFlag(false);
                lock.notify();
            }
        }
    }
}

