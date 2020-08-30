package easy.array;

public class Easy643 {
    /**
     * 找连续的k个值的最大平均数
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<k; i++) {
            count += nums[i];
        }
        double max = count / (double) k;
        for(int i=k; i<nums.length; i++) {
            count = count+nums[i]-nums[i-k];
            max = Math.max(max, count/(double)k);
        }
        return max;
    }
}
