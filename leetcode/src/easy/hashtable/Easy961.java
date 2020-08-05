package easy.hashtable;

import java.util.HashMap;

public class Easy961 {
    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int r = -1;
        for (Integer num : map.keySet()) {
            if (map.get(num) == A.length / 2) {
                return num;
            }
        }
        return r;
    }
}
