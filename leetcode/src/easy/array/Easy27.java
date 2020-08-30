package easy.array;

public class Easy27 {
    public int removeElement(int[] nums, int val) {
        int idx = -1;
        int count = 0;
        // 计算重复的个数
        for(int i=0; i<nums.length; i++) {
            if (val == nums[i]) {
                count += 1;
            }
        }
        for(int i=0; i<nums.length; i++) {
            // 找到重复的idx并完成值交换
            if (val == nums[i]) {
                idx = i;
                exchangeRepeat(nums, idx, val);
            }
        }
        return nums.length - count;
    }

    public void exchangeRepeat(int[] arr, int repeatIdx, int val) {
        for(int i=repeatIdx; i<arr.length; i++) {
            if(arr[i] != val) {
                int temp = arr[i];
                arr[repeatIdx] = temp;
                arr[i] = val;
                break;
            }
        }
    }
}
