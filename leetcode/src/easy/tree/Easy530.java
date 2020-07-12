package easy.tree;

import java.util.*;

public class Easy530 {
    Set<Integer> diff;
    List<Integer> traveled;
    void helper(TreeNode root) {
        if (root == null) return;
        if (traveled.size() > 0) {
            for(Integer n : traveled) {
                int delta = Math.abs(root.val - n);
                diff.add(delta);
            }
        }
        traveled.add(root.val);
        helper(root.left);
        helper(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        diff = new HashSet<>();
        traveled = new ArrayList<>();
        helper(root);
        Integer[] l = diff.toArray(new Integer[diff.size()]);
        Integer minDelta = l[0];
        for(Integer d : l) {
            if (d < minDelta) {
                minDelta = d;
            }
        }
        return minDelta;
    }
}
