package easy.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Easy628 {
    /**
     * 考虑下面几种情况:
     * 1. 全负数
     * 2. 负数 + 零
     * 找最大的三个数相乘即可
     * 3. 一个负数 + [零] + 正数
     * 找最大的三个数相乘即可
     * 4. 一个以上负数 + [零] + 正数
     * 找两个最小的两个(负)数和一个最大的正数
     * 找三个最大的三个数
     * 比较那种会大一些
     * 5. 零 + 正数
     * 找最大的三个数相乘即可
     * 6. 全正数
     * 找最大的三个数相乘即可
     * 总结一下, 上面列举的所有情况
     * 1. 如果有两个及以上的负数
     * (1)找两个最小的两个(负)数和一个最大的正数
     * (2)找最大的三个数
     * 比较那种会大一些, 返回结果即可
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length - 1;
        int r1 = nums[l] * nums[l-1] * nums[l-2];
        int r2 = nums[l] * nums[0] * nums[1];
        return Math.max(r1, r2);
    }
}
