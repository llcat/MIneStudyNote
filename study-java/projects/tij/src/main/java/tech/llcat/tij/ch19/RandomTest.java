package tech.llcat.tij.ch19;

import java.math.BigDecimal;

enum Activity {
    SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMOING, FALLING, FLYING;
}
public class RandomTest {
    public static void main(String[] args) {
        System.out.println(1L << Activity.SITTING.ordinal());
        System.out.println(1L << Activity.LYING.ordinal());
        System.out.println(1L << Activity.STANDING.ordinal());
        System.out.println(1L << Activity.HOPPING.ordinal());
        System.out.println(127L >>> 6);
        System.out.println(Math.pow(2,6));
        for(int i=0; i<20; i++){
            System.out.println(Enums.random(Activity.class));
        }
    }
}
