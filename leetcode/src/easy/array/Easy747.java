package easy.array;

public class Easy747 {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int rIndex = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > max) {
                int nextMax = nums[i];
                if (nums[i] >= 2*max) {
                    rIndex = i;
                } else {
                    rIndex = -1;
                }
                max = nextMax;
            } else if (nums[i] < max) {
                if(nums[i]*2 > max) {
                    rIndex = -1;
                }
            }
        }
        return rIndex;
    }
}
