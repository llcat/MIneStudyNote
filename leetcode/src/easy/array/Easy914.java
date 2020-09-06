package easy.array;

import java.util.HashMap;
import java.util.Map;

public class Easy914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n: deck) {
            count.put(n, count.getOrDefault(n,0)+1);
        }
        int g = count.get(deck[0]);
        for(Integer k : count.values()) {
            g = gcd(g, k);
        }
        if (g < 2) return false;
        return true;
    }

    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b%a, a);
    }
}
