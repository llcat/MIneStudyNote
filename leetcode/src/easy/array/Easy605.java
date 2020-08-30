package easy.array;

public class Easy605 {
    /**
     * 要么
     * 1 0 1 0 1
     * 0 1 0 1 0
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length; i++) {
            int pre = i-1;
            int next = i+1;
            int curVal = flowerbed[i];
            if (flowerbed.length == 1) {
                if (curVal == 0) {
                    n--;
                }
                return n <= 0;
            }
            if (pre < 0) {
                boolean isValid = curVal == 0 && flowerbed[next] != 1;
                if (isValid) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (next >= flowerbed.length) {
                boolean isValid = curVal ==0 && flowerbed[pre] != 1;
                if(isValid) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else {
                boolean isValid = curVal == 0 && flowerbed[pre] != 1 && flowerbed[next] != 1;
                if(isValid) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        int[] f = new int[] {1,0,0,0,0,1};
        new Easy605().canPlaceFlowers(f, 2);
    }
}
