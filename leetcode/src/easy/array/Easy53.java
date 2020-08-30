package easy.array;

public class Easy53 {
    /**
     * 采用动态规划解决, 在能保证前面状态不变时, 当前的状态的计算可以依赖前一个状态何其本身求解
     * 换在这里, 我们求解index=0位置时的最大连续子序列和可以概括成这样
     * 设dp[i]为连续子序列的最大和, 那么dp[i]有下面两种情况
     * 1. dp[i] = dp[i-1] + currentVal
     * 2. dp[i] = currentVal
     * 及从0开始的连续子序列和+当前值的和还没有当前值大, 那么当前的最大子序列和就是当前值, 否则是前一个最大子序列和+当前值
     * 得到状态转移方程
     * dp[i] = max{ dp[i]+currentVal, currentVal }
     * 所以一轮遍历后可以求解出从index=0开始的最大子序列和, 从0开始的最大子序列和就是当前数组的最大子序列和
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int globalSum = Integer.MIN_VALUE;
        for(int num:nums) {
            sum = sum + num > num ? sum+num : num;
            globalSum = sum > globalSum ? sum : globalSum;
        }
        return globalSum;
    }
}
