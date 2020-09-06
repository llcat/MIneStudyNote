package easy.array;

public class Easy905 {
    public int[] sortArrayByParity(int[] A) {
        int[] r = new int[A.length];
        int evenIndex = 0;
        int oddIndex = A.length -1;
        for(int n : A) {
            if (n % 2 == 0) {
                r[evenIndex++] = n;
            } else {
                r[oddIndex--] = n;
            }
        }
        return r;
    }
}
