package easy.sort;

import java.util.Arrays;

public class Easy976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int r = 0;
        for(int i=A.length-1; i>=2; i--) {
            if (A[i-2] + A[i-1] > A[i]) {
                r = A[i-2] + A[i-1] + A[i];
                return r;
            }
        }
        return r;
    }
}
