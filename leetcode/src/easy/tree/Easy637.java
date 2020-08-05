package easy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * #637 求二叉树每一层的平均值
 * 层序遍历并求该层所有节点的平均值即可(用的双Stack记录当前层和下层节点)
 */
public class Easy637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Stack<TreeNode> curLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        curLevel.push(root);
        long sum = 0;
        int size = curLevel.size();
        while (!curLevel.isEmpty()) {
            TreeNode t = curLevel.pop();
            sum += t.val;
            if (t.left != null) nextLevel.push(t.left);
            if (t.right != null) nextLevel.push(t.right);
            if (curLevel.isEmpty()) {
                result.add(sum/((double)size));
                sum = 0;
                size = nextLevel.size();
                curLevel = nextLevel;
                nextLevel = new Stack<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 4;
        int c = 17;
        System.out.println((a+b)/((double) c));
    }
}
