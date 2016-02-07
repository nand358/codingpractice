package library.threads;

/**
 * Created by anatarajan on 1/13/16.
 */
public class ProducerConsumer {


    public static void main(String[] args) {
        Shared s = new Shared();
        new Thread(new Producer(s)).start();
        new Thread(new Consumer(s)).start();
    }
}

class Shared {
    private char c = '\u0000';
    private boolean writeable = true;

    public synchronized char getSharedChar() {
        while (writeable) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        writeable = true;
        notify();
        return c;
    }

    public synchronized void setSharedChar(char ch) {
        while (!writeable) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.c = ch;
        writeable = false;
        notify();
    }

}

class Consumer implements Runnable {
    private Shared s;

    public Consumer(Shared s) {
        this.s = s;
    }

    public void run() {
        char sChar;
        do {
            sChar = s.getSharedChar();
            System.out.println(sChar + " consumed by Consumer");
        } while (sChar != 'Z');
    }


}

class Producer implements Runnable {
    private Shared s;

    public Producer(Shared s) {
        this.s = s;
    }

    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            s.setSharedChar(ch);
            System.out.println(ch + " produced by Producer");
        }
    }

}
