package easy.sort;

import java.util.Arrays;

public class Easy1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        // 根据R, C生成点数组
        int[][] arr = new int[R*C][2];
        for (int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                int index = i*C + j;
                arr[index][0] = i;
                arr[index][1] = j;
            }
        }
        // 排序
        Arrays.sort(arr, (p1, p2) -> {
            int d1 = Math.abs(p1[0] - r0) + Math.abs(p1[1] - c0);
            int d2 = Math.abs(p2[0] - r0) + Math.abs(p2[1] - c0);
            return Integer.compare(d1, d2);
        });
        return arr;
    }
}
