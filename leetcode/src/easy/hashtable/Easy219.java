package easy.hashtable;

import java.util.HashSet;

/**
 * #219 存在重复元素2
 * 思路: 私用一个k大小的HashSet作为滑动窗口, 遍历时判断该滑动窗口中是否有重复值
 */
public class Easy219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> s = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if (s.contains(nums[i])) return true;
            s.add(nums[i]);
            if (s.size() > k) {
                s.remove(nums[i-k]);
            }
        }
        return false;
    }
}
