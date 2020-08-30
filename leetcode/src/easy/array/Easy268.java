package easy.array;

public class Easy268 {
    public int missingNumber(int[] nums) {
        // 0 ~ n有n+1个数
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int n:nums) {
            if (n > max) {
                max = n;
            }
            count += n;
        }
        if(max < nums.length) {
            max = max + 1;
        }
        int total = max*(max+1) / 2;
        return total - count;
    }
}
