package easy.tree;

import java.util.HashMap;
import java.util.Map;

public class Easy437 {
    // 前缀和统计map, k: 前缀和 v: 前缀和出现的次数
    Map<Integer, Integer> prefixSumCounter = null;
    int helper(TreeNode root, int target, int currentSum) {
        if (root == null) return 0;
        int result = 0;
        currentSum += root.val;
        result += this.prefixSumCounter.getOrDefault(currentSum-target, 0);
        this.prefixSumCounter.put(currentSum, this.prefixSumCounter.getOrDefault(currentSum, 0) + 1);
        // 进入下一层
        result += helper(root.left, target, currentSum);
        result += helper(root.right, target, currentSum);
        // 回到本层时将本层的前缀和从统计中移除, 避免回溯到上一层时对统计结果照成错误
        this.prefixSumCounter.put(currentSum, this.prefixSumCounter.get(currentSum) - 1);
        return  result;
    }
    public int pathSum(TreeNode root, int sum) {
        this.prefixSumCounter = new HashMap<>();
        // 为了防止根节点直接命中, 所以需要预置一个前缀和为0的情况
        // 即 root.val - target = 0的情况
        this.prefixSumCounter.put(0, 1);
        return helper(root, sum, 0);
    }
}
