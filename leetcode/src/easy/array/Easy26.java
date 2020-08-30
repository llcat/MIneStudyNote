package easy.array;

public class Easy26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int recordIndex = 0;
        int recordVal = nums[recordIndex];
        for(int i=1; i<nums.length; i++) {
            if (recordVal != nums[i]) {
                recordVal = nums[i];
                recordIndex += 1;
                nums[recordIndex] = nums[i];
            }
        }
        return recordIndex + 1;
    }
}
