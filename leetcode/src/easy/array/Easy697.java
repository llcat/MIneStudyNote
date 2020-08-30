package easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Easy697 {
    public int findShortestSubArray(int[] nums) {
        // 找出现次数最多的数, 一个或多个
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> beg = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        int maxCount = 0;
        for(int i=0; i< nums.length; i++) {
            int n = nums[i];
            count.put(n, count.getOrDefault(n,0)+1);
            maxCount = Math.max(maxCount, count.get(n));
            if(!beg.containsKey(n)) {
                beg.put(n, i);
            }
            end.put(n, i);
        }
        if(maxCount == 1) return 1;
        List<Integer> maxList = new ArrayList<>();
        for(Integer k:count.keySet()) {
            if (count.get(k) == maxCount) {
                maxList.add(k);
            }
        }
        int shortest = Integer.MAX_VALUE;
        for(Integer m : maxList) {
            int b = beg.get(m);
            int e = end.get(m);
            shortest = Math.min(shortest, e-b+1);
        }
        return shortest;
    }
}
