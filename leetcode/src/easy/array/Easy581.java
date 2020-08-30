package easy.array;

public class Easy581 {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1, end = -2;
        int l = nums.length;
        int max = nums[0];
        int min = nums[l-1];
        for(int i=1; i<l; i++) {
            max = Math.max(max, nums[i]);
            if(nums[i] < max) end = i;
            min = Math.min(min, nums[l-1-i]);
            if(nums[l-1-i] > min) start = l-1-i;
        }
        return end-start+1;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,1,1,1,1};
        int[] b = new int[] {3,3,3,1,1,1};
        int[] c = new int[] {1,3,2,2,2};
        int[] d = new int[] {5,4,3,2,1};
        int[] aa = new int[] {1,1,2,2,2,3,4,3,3,3};
        int [] bb = new int[] {1,3,2,3,3};
        Easy581 e = new Easy581();
        e.findUnsortedSubarray(a);
        e.findUnsortedSubarray(b);
        e.findUnsortedSubarray(c);
        e.findUnsortedSubarray(d);
        e.findUnsortedSubarray(aa);
        e.findUnsortedSubarray(bb);
    }
}
