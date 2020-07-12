package easy.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Easy501 {

    Map<Integer, Integer> m;
    void helper(TreeNode root) {
        // 给定的是一颗二叉查找树, 所以它的众数最多出现两次
        if (root == null) return;
        m.put(root.val, m.getOrDefault(root.val, 0) + 1);
        helper(root.left);
        helper(root.right);
    }

    int[] find() {
        int maxV = 0;
        List<Integer> l = new ArrayList<>();
        for (int k : this.m.keySet()) {
            int v = this.m.get(k);
            if (v > maxV) {
                maxV = v;
                l = new ArrayList<>();
                l.add(k);
            } else if (v == maxV) {
                l.add(k);
            }
        }
        int[] r = new int[l.size()];
        for (int i=0; i<l.size(); i++) {
            r[i] = l.get(i);
        }
        return r;
    }

    public int[] findMode(TreeNode root) {
        this.m = new HashMap<>();
        helper(root);
        return find();
    }
}
