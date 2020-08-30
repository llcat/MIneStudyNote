package easy.array;

public class Easy169 {
    public int majorityElement(int[] nums) {
        // 虽然题目要求是找出出现次数大于n/2的数
        // 但由于假定了该数一定存在, 所以只需找出出现次数最多的数即可
        int majority = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++) {
            if(count == 0) {
                majority = nums[i];
                count = 1;
                continue;
            }
            if (majority == nums[i]) {
                count ++;
            } else {
                count --;
            }
        }
        return majority;
    }
}
