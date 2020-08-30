package easy.array;

public class Easy283 {
    public void moveZeroes(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                for(int j=i+1; j<nums.length; j++) {
                    if(nums[j] !=0) {
                        int temp = nums[j];
                        nums[i] = temp;
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}
