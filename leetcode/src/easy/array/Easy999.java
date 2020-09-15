package easy.array;

public class Easy999 {
    public int numRookCaptures(char[][] board) {
        int R=0, C = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if (board[i][j] == 'R') {
                    R = i;
                    C = j;
                    break;
                }
            }
        }
        int count = 0;
        // 左上右下步进
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        for(int i=0; i<dx.length; i++) {
            for(int step=0;;step++) {
                int sx = R + dx[i] * step;
                int sy = C + dy[i] * step;
                if(sx < 0 || sx >=8 || sy < 0 || sy >=8 || board[sx][sy]=='B') break;
                if (board[sx][sy] == 'p') {
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }
}
