package easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历
 */
public class Easy107 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if (root != null) {
            List<List<TreeNode>> levels = new ArrayList<>();
            List<TreeNode> levelNodes = new ArrayList<>();
            levelNodes.add(root);
            // 第0层
            levels.add(levelNodes);
            while (levels.size() > 0) {
                List<TreeNode> nodes = levels.get(0);
                List<Integer> curLevelNums = new ArrayList<>();
                List<TreeNode> nextLevelNodes = new ArrayList<>();
                for (TreeNode n : nodes) {
                    curLevelNums.add(n.val);
                    if (n.left != null) {
                        nextLevelNodes.add(n.left);
                    }
                    if (n.right != null) {
                        nextLevelNodes.add(n.right);
                    }
                }
                levels.add(0, nextLevelNodes);
                r.add(0, curLevelNums);
                if (nextLevelNodes.size() == 0) {
                    break;
                }
            }
        }
        return r;
    }
}
