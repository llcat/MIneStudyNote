package easy.array;

public class Easy985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int R = queries.length;
        int[] r = new int[R];
        int evenCount = 0;
        for(int n : A) {
            evenCount += n % 2 == 0 ? n : 0;
        }
        for(int i=0; i<R; i++) {
            int v = queries[i][0];
            int index = queries[i][1];
            int preV = A[index];
            A[index] = A[index] + v;
            if (A[index] % 2 == 0) {
                if (preV % 2 == 0) {
                    evenCount = evenCount - preV + A[index];
                } else {
                    evenCount += A[index];
                }
            } else {
                if (preV % 2 == 0) {
                    evenCount -= preV;
                }
            }
            r[i] = evenCount;
        }
        return r;
    }
}
