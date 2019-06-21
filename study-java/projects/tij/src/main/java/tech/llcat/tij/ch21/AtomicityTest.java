package tech.llcat.tij.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private int i = 0;
    private int getValue() {
        return i;
    }
    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        es.execute(at);
        while (true) {
            int val = at.getValue();
            if(val%2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
