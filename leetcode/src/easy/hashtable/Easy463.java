package easy.hashtable;

/**
 * #463 岛屿的周长
 * 思路：我的思路是遍历点数组，就硬算, 判断该点到上下左右相邻4个点的情况。
 * 分为3种情况
 * 1. 为边界(越界), 周长加一
 * 2. 为水格子，周长加一
 * 3. 为岛屿格子,不加
 * 看了别人的题解，有用dfs递归遍历岛屿格子的，比较优雅
 * 好处是不用遍历所有的点格子
 */
public class Easy463 {
    int dfs(int[][] grid, int row, int col) {
        // 超出边界
        if (!(row >=0 && row<grid.length && col>=0 && col<grid[0].length)) {
            return 1;
        }
        // 从岛屿走到水域
        if (grid[row][col] == 0) {
            return 1;
        }
        // 碰到已经遍历过的格子
        if (grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;
        return dfs(grid, row-1, col)
                +dfs(grid, row+1, col)
                +dfs(grid, row, col-1)
                +dfs(grid, row, col+1);
    }

    public int islandPerimeter(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }
}
