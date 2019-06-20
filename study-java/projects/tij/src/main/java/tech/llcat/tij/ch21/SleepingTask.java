package tech.llcat.tij.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff{
    @Override
    public void run() {
        try {
            while (countDown-- > 0){
                System.out.println(status());
                TimeUnit.MICROSECONDS.sleep(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++){
            es.execute(new SleepingTask());
        }
        es.shutdown();
    }
}
