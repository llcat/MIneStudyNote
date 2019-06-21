package tech.llcat.tij.ch21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Accessor implements Runnable {
    private final int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "Accessor{" +
                "id=" + id +
                '}'+ThreadLocalVariableHolder.get();
    }
}
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random rand = new Random(47);
        @Override
        protected Integer initialValue() {
            return rand.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get()+1);
    }

    public static int get(){
        return value.get();
    }

    public static void main(String[] args)  throws Exception{
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            es.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        es.shutdownNow();
    }
}
