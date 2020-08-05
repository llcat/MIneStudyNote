package easy.tree;

/**
 * #1022 从根到叶的二进制数之和
 * 思路: 前序遍历二叉树, 到叶子节点计算二进制数值并累加即可。
 * 我用的String记录根节点到叶子节点的字符串, 在做频繁的+操作时效率很低, 换用StringBuilder或StringBuffer效果更佳
 */
public class Easy1022 {
    int r;
    void helper(TreeNode root, String s) {
        if (root == null) return;
        String c = s + root.val;
        if (root.left == null && root.right == null) {
            r += Integer.parseInt(c, 2);
        }
        helper(root.left, c);
        helper(root.right, c);
    }
    public int sumRootToLeaf(TreeNode root) {
        r = 0;
        helper(root, "");
        return r;
    }

    public static void main(String[] args) {
        String a = "" + 1;
        a = a + 0;
        a = a + 1;
        System.out.println(Integer.parseInt(a, 2));
    }
}
