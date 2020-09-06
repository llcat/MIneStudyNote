package easy.array;

public class Easy849 {
    public int maxDistToClosest(int[] seats) {
        // 说白了是个找最长连续0序列的问题
        int maxD = 0;
        int count = 0;
        for (int i=0; i<seats.length; i++) {
            if(seats[i] == 0) {
                count += 1;
                boolean c1 = i - count + 1 == 0;
                boolean c2 = i == seats.length -1;
                if (c1 || c2) {
                    maxD = Math.max(count, maxD);
                } else {
                    boolean c3 = count / 2 > maxD;
                    boolean c4 = (count / 2) + 1 > maxD;
                    if (c3 || c4) {
                        if (count % 2 == 0) {
                            maxD = Math.max(count / 2, maxD);
                        } else {
                            maxD = Math.max(count / 2 + 1, maxD);
                        }
                    }
                }
            } else {
                count = 0;
            }
        }
        return maxD;
    }

    public static void main(String[] args) {
        int[] t = new int[] {1,0,0,0,0,0,1};
        int[] t1 = new int[] {0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,1};
        new Easy849().maxDistToClosest(t1);
    }
}
