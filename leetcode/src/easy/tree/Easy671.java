package easy.tree;

import java.util.Set;
import java.util.TreeSet;

/**
 * #671 找出二叉树中第二小的节点值
 * 思路: 遍历二叉树, 使用TreeSet存节点值, TreeSet插入是有序的
 * set.size小于2,返回-1, 大于二, pollFirst两次并返回即可
 */
public class Easy671 {
    TreeSet<Integer> set;

    void helper(TreeNode root) {
        if (root == null) return;
        set.add(root.val);
        helper(root.left);
        helper(root.right);
    }
    public int findSecondMinimumValue(TreeNode root) {
        set = new TreeSet<>();
        helper(root);
        if (set.size() < 2) {
            return -1;
        } else {
            set.pollFirst();
            return set.pollFirst();
        }
    }

    public static void main(String[] args) {
        TreeSet<Integer> s = new TreeSet<>();
        s.add(5);
        s.add(1);
        s.add(4);
        System.out.println(s.pollFirst());
    }
}
