package easy.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int count = 0;
            for(int j=0; j<nums.length; j++) {
                if(j!=i && nums[j] < nums[i]) {
                    count += 1;
                }
            }
            list.add(count);
        }
        int[] r = new int[list.size()];
        for(int i=0; i<r.length; i++) {
            r[i] = list.get(i);
        }
        return r;
    }
}
