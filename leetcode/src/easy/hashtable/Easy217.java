package easy.hashtable;

import java.util.HashSet;

/**
 * #217 存在重复元素
 */
public class Easy217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (s.contains(num)) return true;
            s.add(num);
        }
        return false;
    }
}
