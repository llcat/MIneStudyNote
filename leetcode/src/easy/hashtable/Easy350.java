package easy.hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class Easy350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int minLength = Math.min(nums1.length, nums2.length);
        int[] result = new int[minLength];
        int index = 0;
        for (int n : nums2) {
            int count = map.getOrDefault(n, 0);
            if (count > 0) {
                result[index++] = n;
                count = count -1;
                map.put(n, count);
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}
