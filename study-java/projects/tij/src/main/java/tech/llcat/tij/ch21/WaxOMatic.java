package tech.llcat.tij.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {
    private boolean waxOn = false;
    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffered() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException{
        while (!waxOn){
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException{
        while (waxOn){
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car c) {
        car = c;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                System.out.println("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car c) {
        car = c;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                car.waitForBuffing();
                System.out.println("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffered();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}
public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new WaxOff(car));
        es.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        es.shutdownNow();
    }
}
