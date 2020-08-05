package easy.tree;

/**
 * #783 求BST任意两节点的最小差值
 * 与#530是一样的题, 今天换了种解法,
 * 中序遍历BST保证有序, 故相邻两节点最小的差值就是BST任意两节点最小差值，
 * 保存访问的前一个节点, 与当前节点值相减, 遍历一遍二叉树即可找出最小值
 */
public class Easy783 {
    Integer pre, min;

    void inOrderTravel(TreeNode root) {
        if (root == null) return;
        inOrderTravel(root.left);
        if (pre != null) min = Math.min(min, root.val - pre);
        pre = root.val;
        inOrderTravel(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        pre = null;
        min = Integer.MAX_VALUE;
        inOrderTravel(root);
        return min;
    }
}
