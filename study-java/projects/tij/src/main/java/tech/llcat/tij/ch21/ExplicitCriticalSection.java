package tech.llcat.tij.ch21;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public synchronized void increment() {
        lock.lock();
        try{
            p.incrementX();
            p.incrementY();
            store(getPair());
        }finally {
            lock.unlock();
        }
    }
}

class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();
    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
            store(temp);
        } finally {
            lock.unlock();
        }
    }
}

public class ExplicitCriticalSection {
    public static void main(String[] args) {
        PairManager pm1 = new ExplicitPairManager1(),pm2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pm1, pm2);
    }

}
