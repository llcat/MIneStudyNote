package easy.hashtable;

import java.util.HashSet;

public class Easy202 {
    int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n !=1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Easy202().getNext(155));
    }
}
