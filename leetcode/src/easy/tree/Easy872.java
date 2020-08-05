package easy.tree;

import java.util.ArrayList;

/**
 * #872 判断给定的两颗二叉树是否叶子相似
 * 分别遍历给定的两颗二叉树, 并保存访问的叶子节点到两个数组
 * 遍历完成后比对两个数组是否一致即可
 */
public class Easy872 {
    boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    void travel(TreeNode t, ArrayList<Integer> l) {
        if (t == null) return;
        if (isLeaf(t)) l.add(t.val);
        travel(t.left, l);
        travel(t.right, l);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        travel(root1, l1);
        travel(root2, l2);
        boolean r =true;
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            int a = l1.get(i);
            int b = l2.get(i);
            if (a != b) {
               r = false;
            }
        }
        return r;
    }
}
