package easy.array;

public class Easy840 {
    public int numMagicSquaresInside(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int count = 0;
        for( int i=2; i<R; i++) {
            for(int j=2; j<C; j++) {
                if (isMagic(i-3+1, j-3+1, grid)) {
                    count+=1;
                }
            }
        }
        return count;
    }

    public boolean isMagic(int sr, int sc, int[][] grid) {
        // 检查不同的1-9;
        int[] map = new int[9];
        int[] rowC = new int[3];
        int[] colC = new int[3];
        for(int i=sr; i<sr+3; i++) {
            for(int j=sc; j<sc+3; j++) {
                int v = grid[i][j];
                rowC[i-sr] += v;
                colC[j-sc] += v;
                if (v < 1 || v > 9) {
                    return false;
                }
                map[v-1] = 1;
            }
        }
        int count = 0;
        for(int m : map) {
            count += m;
        }
        if (count != 9) {
            return false;
        }
        // 检查diagonal
        int[] diagonal = new int[2];
        for(int i=sr, j=sc, k=sc+2; i<sr+3; i++,j++,k--) {
            diagonal[0] += grid[i][j];
            diagonal[1] += grid[i][k];
        }

        // 确认每行, 每列, 每个对角线都相等
        // 和值一定大于0
        int cc = rowC[0];
        for(int i=0; i<rowC.length; i++) {
            if (rowC[i] == 0) return false;
            if (cc != rowC[i]) return false;
            if (cc != colC[i]) return false;
        }
        for(int i=0; i<diagonal.length; i++) {
            if(diagonal[i] == 0) return false;
            if (cc != diagonal[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] t = new int[][]{
                new int[]{4,3,8,4},
                new int[]{9,5,1,9},
                new int[]{2,7,6,2}};
        int[][] t1 = new int[][]{
                new int[]{3,2,9,2,7},
                new int[]{6,1,8,4,2},
                new int[]{7,5,3,2,7},
                new int[]{2,9,4,9,6},
                new int[]{4,3,8,2,5}
        };
        int c = new Easy840().numMagicSquaresInside(t1);
        System.out.println(c);
    }
}
