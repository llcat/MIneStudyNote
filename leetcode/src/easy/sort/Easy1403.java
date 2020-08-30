package easy.sort;

import java.util.ArrayList;
import java.util.List;

public class Easy1403 {
    public List<Integer> minSubsequence(int[] nums) {
        // 计算数组总和
        int count = 0;
        for(int num:nums) {
            count += num;
        }
        int tempCount = 0;
        List<Integer> r = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int maxIndex = i;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            int maxValue = nums[maxIndex];
            int temp = nums[i];
            nums[i] = maxValue;
            nums[maxIndex] = temp;
            tempCount += maxValue;
            r.add(maxValue);
            if (tempCount > count-tempCount) {
                return r;
            }
        }
        return r;
    }
}
