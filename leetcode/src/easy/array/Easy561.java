package easy.array;

import java.util.Arrays;

public class Easy561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0; i<nums.length; i=i+2) {
            count+=nums[i];
        }
        return count;
    }
}
