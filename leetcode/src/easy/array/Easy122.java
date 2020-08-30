package easy.array;

public class Easy122 {

    public int maxProfit(int[] prices) {
        return helper(prices, 0, prices.length-1);
    }
    // 找到某个区间内的最大正向收入即可
    public int helper(int[] prices, int start, int end) {
        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=start; i<=end; i++) {
            int profit = prices[i] - minBuyPrice;
            minBuyPrice = prices[i] < minBuyPrice ? prices[i] : minBuyPrice;
            maxProfit = maxProfit < profit ? profit : maxProfit;
            if (maxProfit > 0) {
                maxProfit += helper(prices, i, end);
                break;
            }
        }
        return maxProfit;
    }
}
