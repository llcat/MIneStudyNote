package easy.array;

public class Easy35 {
    public int searchInsert(int[] nums, int target) {
        int mayIndex = -1;
        for(int i=0; i<nums.length; i++) {
            if (target == nums[i]) {
                mayIndex = i;
                return mayIndex;
            } else if (target > nums[i]) {
                mayIndex = i;
            } else {
                break;
            }
        }
        return mayIndex + 1;
    }
}
