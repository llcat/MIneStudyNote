package easy;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Easy938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val >= L && root.val <=R) {
            count = root.val;
        }
        count += rangeSumBST(root.left, L, R);
        count += rangeSumBST(root.right, L, R);
        return count;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        int count = new Easy938().rangeSumBST(n1, 4, 9);
        System.out.println(count);
    }
}
