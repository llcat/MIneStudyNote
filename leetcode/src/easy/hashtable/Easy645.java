package easy.hashtable;

import java.util.HashMap;

public class Easy645 {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int repeat = 0;
        int miss = 1;
        for (int i=1; i<=nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    repeat = i;
                }
            } else {
                miss = i;
            }
        }
        return new int[] {repeat, miss};
    }
}
