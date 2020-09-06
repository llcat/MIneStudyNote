package easy.array;

public class Easy832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int R = A.length;
        for(int i=0; i<R; i++) {
            flipConvertOneRow(A[i]);
        }
        return A;
    }

    public void flipConvertOneRow(int[] r) {
        int mid = r.length / 2;
        if (r.length % 2 != 0) {
            r[mid] = r[mid] == 0 ?  1 : 0;
        }
        for(int i=0; i<mid; i++) {
            int temp = r[i];
            r[i] = r[r.length-1-i] == 0 ? 1 : 0;
            r[r.length-1-i] = temp == 0 ? 1 : 0;
        }
    }
}
