package easy.array;

public class Easy121 {
    // 动态规划 O(n)
    public int maxProfit(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int p: prices) {
            int profit = p - minBuyPrice;
            minBuyPrice = p < minBuyPrice ? p : minBuyPrice;
            maxProfit = maxProfit < profit ? profit : maxProfit;
        }
        return maxProfit;
    }
    // O(n^2)
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j<prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = profit > maxProfit ? profit : maxProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        new Easy121().maxProfit(new int[] {7,1,5,3,6,4});
    }
}
