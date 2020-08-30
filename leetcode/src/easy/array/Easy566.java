package easy.array;

public class Easy566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if(r*c != row*col) {
            return nums;
        }
        int[][] reshape = new int[r][c];
        int rowIndex = 0;
        int colIndex = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                reshape[rowIndex][colIndex] = nums[i][j];
                colIndex++;
                if (colIndex >= c) {
                    colIndex = 0;
                    rowIndex++;
                }
            }
        }
        return reshape;
    }
}
