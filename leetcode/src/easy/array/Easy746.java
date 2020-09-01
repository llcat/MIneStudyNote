package easy.array;

public class Easy746 {
    /**
     * 又是一个动态规划问题
     * 从最小的例子开始归纳动态迁移方程
     * 可以从第一层或第二层开始, 每次可以跳1到2层
     * 所以第三层可以是从第一层跳过去, 也可以是从第二层跳过去。
     * 我们用一个dp状态数组保存迁移的状态
     * dp[0] = cost[0] 第一层的最小dp
     * dp[1] = cost[1] 第二层的最小dp
     * dp[2] = min(dp[0]+cost[2], dp[1]+cost[2])
     *
     * 依此类推, 我们可以得出状态迁移方程如下
     * dp[i] = min(dp[i-2]+cost[i], dp[i-1]+cost[i])
     *
     * 通过状态迁移方程可以计算整个dp状态数组, 可知
     * 登顶的最小消耗为 min(dp[i-1], dp[i])
     *
     * 优化建议:
     * 这里我们用了dp数组保持了所有的迁移状态, 实际运算时
     * 我们总是只取前面的两个dp状态计算下一个dp状态, 所以用两个
     * 整数就足够呢, 这样可以把空间复杂度优化到O(1)
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int dp1 = cost[0];
        int dp2 = cost[1];
        for(int i=2; i<cost.length; i++) {
            int curDp = Math.min(dp1+cost[i], dp2+cost[i]);
            dp1 = dp2;
            dp2 = curDp;
        }
        return Math.min(dp1, dp2);
    }
}
