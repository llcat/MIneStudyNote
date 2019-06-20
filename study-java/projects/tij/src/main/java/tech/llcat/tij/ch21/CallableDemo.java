package tech.llcat.tij.ch21;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Consumer;

class TaskWithResult implements Callable<String> {
    private  int id;

    public TaskWithResult(int id) {
        this.id = id;
    }



    @Override
    public String call() throws Exception {
        return "result: "+id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        ArrayList<Future<String>> arr = new ArrayList<>();

        for(int i=0; i<10; i++)
            arr.add(es.submit(new TaskWithResult(i)));

        arr.forEach(f -> {
            try{
                System.out.println(f.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        es.shutdown();
    }
}
