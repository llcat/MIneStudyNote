package easy.array;

public class Easy665 {
    /**
     * 找出逆序的个数. 大于1的话就不能修改一个数字调整为正序
     * 逐个找逆序对, 但要考虑一些特殊情况
     * eg: 1,2,3,1        yes
     * eg: 1,2,3,2        yes
     * eg: 1,2,3,1,2      no
     * eg: 1,2,3,1,9      yes
     * eg: 1,2,9,5,7,8    yes
     * eg: 1,6,9,7,8,11   yes
     * eg: 1,6,9,4,5      no
     * eg: 1,2,3,2,2      yes
     * eg: 1,6,9,4,6      no
     * eg: 1,6,9,4,11     yes
     * 总结:
     * 针对只能找打一对逆序的情况, 有下面几种情况
     * [..., max] [rBigger, rSmaller]
     * 一定可以, 调整rSmaller即可。
     * [rBigger, rSmaller] [min, ....]
     * 一定可以, 调整rBigger即可
     * [..., max] [rBigger, rSmaller] [min, ....]
     * 由于确定只有一对逆序对, 所以rBigger >= max, rSmaller <= min
     * if max <= min
     * 确保 Math.min(rBigger, rSmaller) >= max 并且 Math.min(rBigger, rSmaller) <= min时可以
     * if max > min
     * 一定不行
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int rCount = 0;
        int rIndex = -99;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                rCount += 1;
                rIndex = i;
            }
        }
        if (rCount > 1) {
            return false;
        }
        if(rIndex == 0 || rIndex == nums.length-2) {
            return true;
        } else if(rIndex > 0){
            int max = nums[rIndex-1];
            int min = nums[rIndex+2];
            if (max > min) return false;
            if(max <= min) {
                int rMin = Math.min(nums[rIndex], nums[rIndex+1]);
                int rMax = Math.max(nums[rIndex], nums[rIndex+1]);
                return rMin >= max && rMin <= min || rMax >=max && rMax <=min;
            }
        }
        return true;
    }
}
