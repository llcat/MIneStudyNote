package easy.array;

public class Easy674 {
    public int findLengthOfLCIS(int[] nums) {
        int temp = 1;
        int global = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] < nums[i]) {
                temp += 1;
            } else {
                temp = 1;
            }
            global = Math.max(global, temp);
        }
        if (nums.length==0) return 0;
        return global;
    }

    public static void main(String[] args) {
        int[] t = new int[] {1,3,5,4,2,3,4};
        new Easy674().findLengthOfLCIS(t);
    }
}
