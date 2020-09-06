package easy.array;

public class Easy766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int R = matrix.length;
        for(int i=0; i<R-1; i++) {
            int[] r1 = matrix[i];
            int[] r2 = matrix[i+1];
            if (!checkTowRow(r1, r2)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkTowRow(int[] r1, int[] r2) {
        for(int i=0; i<r1.length-1; i++) {
            if (r1[i] != r2[i+1]) {
                return false;
            }
        }
        return true;
    }
}
