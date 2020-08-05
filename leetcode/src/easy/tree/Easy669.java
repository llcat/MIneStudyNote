package easy.tree;

/**
 * #669 修剪二叉搜索树
 * 思路：后序遍历二叉树, 根节点值满足给定边界, 返回根节点,
 * 小于给定左边界, 返回右子树, 小于给定右边界，返回左子树
 */
public class Easy669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        TreeNode lson = trimBST(root.left, L, R);
        TreeNode rson = trimBST(root.right, L, R);
        root.left = lson;
        root.right = rson;
        if(root.val >= L && root.val <= R) return root;
        else if (root.val < L) return rson;
        else return lson;
    }
}
