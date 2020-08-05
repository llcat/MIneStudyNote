package easy.hashtable;

import java.util.HashSet;

public class Easy575 {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for(int c:candies) {
            set.add(c);
        }
        int typeCount = set.size();
        int half = candies.length / 2;
        if (typeCount >= half) {
            return half;
        } else {
            return typeCount;
        }
    }

    public static void main(String[] args) {
        new Easy575().distributeCandies(new int[] {1, 1,2});
    }
}
