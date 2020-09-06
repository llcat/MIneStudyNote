package easy.array;

import java.util.Map;

public class Easy977 {
    public int[] sortedSquares(int[] A) {
        int[] r = new int[A.length];
        int start = 0;
        int end = A.length-1;
        for(int i=r.length-1; i>=0; i--) {
            boolean endBigger = Math.abs(A[end]) > Math.abs(A[start]);
            if (endBigger) {
                r[i] = A[end] * A[end];
                end--;
            } else {
                r[i] = A[start] * A[start];
                start++;
            }
        }
        return r;
    }
}
