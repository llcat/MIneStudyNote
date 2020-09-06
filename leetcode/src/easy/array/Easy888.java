package easy.array;

public class Easy888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] r = new int[2];
        int cA = 0, cB = 0;
        int maxL = Math.max(A.length, B.length);
        for(int i=0; i<maxL; i++) {
            if (i < A.length) {
                cA += A[i];
            }
            if (i < B.length) {
                cB += B[i];
            }
        }
        int sub = (cB - cA)/2;
        for(int a : A) {
            for(int b : B) {
                if (b - a == sub) {
                    r[0] = a;
                    r[1] = b;
                    return r;
                }
            }
        }
        return r;
    }
}
