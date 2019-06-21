package tech.llcat.tij.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator g, int ident){
        generator = g;
        id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val = generator.next();
            if( val % 2 != 0){
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator g, int count){
        System.out.println("Press Ctrl-C to exit!");
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            es.execute(new EvenChecker(g, count));
        }
        es.shutdown();
    }
    public static void test(IntGenerator g){
        test(g, 10);
    }
}
