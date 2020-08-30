package easy.array;

public class Easy189 {
    // 时间换空间
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k%nums.length;
        }
        while (k!=0) {
            k--;
            int last = nums[nums.length-1];
            System.arraycopy(nums,0, nums, 1, nums.length-1);
            nums[0] = last;
        }
    }

    // 空间换时间
    public void rotate1(int[] nums, int k) {
        if (k > nums.length) {
            k = k%nums.length;
        }
        int[] temp = new int[k];
        int index = nums.length - k;
        if (index >=0 && index<=nums.length-1) {
            // 复制到temp
            System.arraycopy(nums, index, temp, 0, k);
            // 后移原数组
            System.arraycopy(nums, 0, nums, k, nums.length-k);
            // 复制temp到源数组
            System.arraycopy(temp, 0, nums, 0, k);
        }
    }

    public static void main(String[] args) {
        int[] t = new int[] {1,2,3,4,5,6,7};
//        int[] t = new int[] {-1,-100,3,99};
//        t = new int[] {1,2,3};
        new Easy189().rotate1(t, 3);
    }
}
