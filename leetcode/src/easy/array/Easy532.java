package easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Easy532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(i>=1 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] - nums[i] == k) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new Easy532().findPairs(new int[] {3,1,4,1,5}, 2);
    }
}
