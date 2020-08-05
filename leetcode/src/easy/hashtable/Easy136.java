package easy.hashtable;

public class Easy136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int i=0; i<nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }
}
