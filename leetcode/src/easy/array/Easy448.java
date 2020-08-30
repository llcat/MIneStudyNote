package easy.array;

import java.util.ArrayList;
import java.util.List;

public class Easy448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> r = new ArrayList<>();
        // 标记有数的位置的值为负数
        for(int n : nums) {
            int index = Math.abs(n) -1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        // 在此遍历, 没有变成负数的位置就是之前不存在的值
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                r.add(i+1);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,3,2,7,8,2,3,1};
        new Easy448().findDisappearedNumbers(arr);
    }
}
