package easy.array;

public class Easy724 {
    public int pivotIndex(int[] nums) {
        // 计算总值
        int count = 0;
        for(int n:nums) {
            count+=n;
        }
        int left=0;
        int right=0;
        int pivotIndex = -1;
        for(int i=0; i<nums.length; i++) {
            int preIndex = i-1;
            if (preIndex >=0 && preIndex<=nums.length-1) {
                left = left + nums[preIndex];
            }
            right = count-nums[i]-left;
            if(left==right) {
                return i;
            }
        }
        return pivotIndex;
    }
}
