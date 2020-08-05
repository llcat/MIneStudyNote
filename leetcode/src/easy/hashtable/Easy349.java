package easy.hashtable;

import java.util.ArrayList;
import java.util.HashSet;

public class Easy349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i< nums1.length; i++) {
            set.add(nums1[i]);
        }
        HashSet<Integer> l = new HashSet<>();
        for (int i=0; i<nums2.length; i++) {
            if (set.contains(nums2[i])) {
                l.add(nums2[i]);
            }
        }
        int[] r = new int[l.size()];
        int i = 0;
        for (Integer n:l) {
            r[i] = n;
            i++;
        }
        return r;
    }

    public static void main(String[] args) {
        new Easy349().intersection(new int[]{1,2,2,1}, new int[]{2,2});
    }
}
