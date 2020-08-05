package easy.hashtable;

import java.util.Map;
import java.util.TreeMap;

public class Easy594 {
    public int findLHS(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num:nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int longest = 0;
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> c = map.pollFirstEntry();
            Map.Entry<Integer, Integer> n = map.firstEntry();
            if (n!=null) {
                if (n.getKey() - c.getKey() == 1) {
                    int l = n.getValue() + c.getValue();
                    if (l > longest) {
                        longest = l;
                    }
                }
            }
        }
        return longest;
    }
}
