package easy.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : arr) {
            map.put(n, map.getOrDefault(n,0)+1);
        }
        Set<Integer> set = new HashSet<>();
        boolean isOk = true;
        for(Integer n:map.values()) {
            if (set.contains(n)) {
                isOk = false;
                break;
            } else {
                set.add(n);
            }
        }
        return isOk;
    }
}
