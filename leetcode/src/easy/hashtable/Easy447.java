package easy.hashtable;

import java.util.HashMap;

/**
 * #447 回旋镖的数量
 * 思路: 遍历点数组，找出能与当前点构成回旋镖的所有点个数
 * 题目要求考虑点的顺序不同也为不同的回旋镖，所以实际上知道了
 * 点的个数，就是个排列问题，计算从n个点中任取2(2≤n)个点的所有排列的个数
 */
public class Easy447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i=0; i<points.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0; j<points.length; j++) {
                int[] origin = points[i];
                int[] p = points[j];
                int dx = p[0] - origin[0];
                int dy = p[1] - origin[1];
                int distance = dx * dx + dy * dy;
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (Integer k : map.values()) {
                ans += k * (k-1);  // 在该序列中任取两个数排列,如A5,2 = 5 * 4, 见排列公式
            }
        }
        return ans;
    }
}
