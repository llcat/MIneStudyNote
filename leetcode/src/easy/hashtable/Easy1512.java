package easy.hashtable;

public class Easy1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] map = new int[101];
        for(int num: nums) {
            map[num] += 1;
        }
        int r = 0;
        for(int count: map) {
            int last = count - 1;
            if (last >= 1) {
                int t = ((1+last) * last)/2;
                r += t;
            }
        }
        return r;
    }
}
