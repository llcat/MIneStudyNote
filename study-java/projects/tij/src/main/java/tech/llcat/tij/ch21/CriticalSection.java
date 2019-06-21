package tech.llcat.tij.ch21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Pair {
    // not thread safe
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0,0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public class PairValueNotEqualException extends RuntimeException {
        public PairValueNotEqualException() {
            super("Pair values not equal: "+Pair.this);
        }
    }

    public void checkState(){
        if(x != y){
            throw new PairValueNotEqualException();
        }
    }
}

abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());
    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }

    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();
}

class PairManager1 extends PairManager {
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) pm.increment();
    }

    @Override
    public String toString() {
        return "Pair: "+pm.getPair()+" checkCounter= "+pm.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true){
            pm.checkCounter.incrementAndGet();
            //可以看到PairManager2由于使用了同步代码块，可以更小粒度的控制同步，从而将耗时的store()操作移到外部，造成两个checkState次数差异很大
            pm.getPair().checkState();
        }
    }
}

public class CriticalSection {
    static void testApproaches(PairManager pm1, PairManager pm2){
        ExecutorService es = Executors.newCachedThreadPool();
        PairManipulator pmp1 = new PairManipulator(pm1), pmp2 = new PairManipulator(pm2);
        PairChecker pc1 = new PairChecker(pm1), pc2 = new PairChecker(pm2);
        es.execute(pmp1);
        es.execute(pmp2);
        es.execute(pc1);
        es.execute(pc2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("pmp1: "+pmp1+"\npmp2: "+pmp2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pm1 = new PairManager1(),
                pm2 = new PairManager2();
        testApproaches(pm1, pm2);
    }
}
