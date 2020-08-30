package easy.array;

public class Easy485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int tempConsecutive = 0;
        for(int n:nums) {
            if(n==1) {
                tempConsecutive += 1;
                maxConsecutive = tempConsecutive > maxConsecutive ? tempConsecutive : maxConsecutive;
            } else {
                tempConsecutive = 0;
            }
        }
        return maxConsecutive;
    }
}
