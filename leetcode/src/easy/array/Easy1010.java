package easy.array;

public class Easy1010 {
    /**
     * 这道题本身来讲是很简单的, t = x=time[i], x = time[j], i<j
     * 保证 (t+x) % 60 == 0 即可, 最简单的方法是遍历, 但是复杂度太高呢,
     * O(n^2), 提升点在于怎么把时间复杂度降成O(n)
     * 考虑
     * 已知 t % 60 的余数是[0, 59]
     * 对于每个t, 我们想知道在time数组中存在多少个x, 满足(t+x) % 60 == 0
     * 或者说是, 对于每个x, 在前面能找到多少个t满足(t+x) % 60 == 0
     * 我们可以推导出一个覆盖大多数情况的表达式
     * (t % 60) + (x % 60) == 60 等价于 (t+x) % 60 == 0
     * 还需要排除一些特殊情况, 如 t % 60 ==0 && x % 60 == 0就不满足
     * 这种特殊情况, 在对差做一次取余即可, 如下
     * (t % 60) == (60 - (x % 60)) % 60
     * 遍历数组, 记录 t % 60出现的次数, 下一个x满足上面的式子就是这个位置上
     * 会与前面的t满足题目条件的个数呢
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        int res = 0;
        for(int t : time) {
            res += map[(60 - t%60)%60];
            map[t % 60] += 1;
        }
        return res;
    }
}
