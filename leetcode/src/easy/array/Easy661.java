package easy.array;

public class Easy661 {
    public int[][] imageSmoother(int[][] M) {
        int R = M.length;
        int C = M[0].length;
        int[][] r = new int[R][C];
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                int count = 0;
                for(int rIndex = i-1; rIndex <= i+1; rIndex++) {
                    for(int cIndex = j-1; cIndex <=j+1; cIndex++) {
                        if (rIndex >=0 && rIndex < R && cIndex >=0 && cIndex<C) {
                            count++;
                            r[i][j] += M[rIndex][cIndex];
                        }
                    }
                }
                r[i][j] = r[i][j] / count;
            }
        }
        return r;
    }
}
