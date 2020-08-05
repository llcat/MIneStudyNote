package easy.tree;

import java.util.ArrayList;

public class Easy563 {
    ArrayList<Integer> tilts;

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int lSum, rSum;
        lSum = dfs(root.left);
        rSum = dfs(root.right);
        tilts.add(Math.abs(lSum - rSum));
        return lSum + rSum + root.val;
    }

    public int findTilt(TreeNode root) {
        tilts = new ArrayList<>();
        dfs(root);
        int tilt = 0;
        for (Integer i : tilts) {
            tilt += i;
        }
        return tilt;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        int t = new Easy563().findTilt(root);
    }
}
