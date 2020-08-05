package easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * #653 求BST是否存在任意两节点值之和等于给定的值
 * 思路：用的老套路, 遍历记录所有节点, 每访问一个节点判断一次, 慢的一匹
 * 解析: 官方题解用的是Set解决, 每遍历一个节点将该节点放到Set记录, 如果后面
 * 当问其他节点时符合set.contain(target - curNode.val), 即可说明存在两节点之和
 * 等于给定值(教训: 活用数据结构, 不要啥都列表一把梭🌚)
 * */
public class Easy653 {
    boolean r;
    List<Integer> record = new ArrayList<>();
    // BST: 左孩子小于等于根节点值, 右子树比根节点值大
    void dfs(TreeNode t, int target) {
        if (t == null) return;
        for(Integer d : record) {
            if (d + t.val == target) {
                r = true;
            }
        }
        record.add(t.val);
        dfs(t.left, target);
        dfs(t.right, target);
    }
    public boolean findTarget(TreeNode root, int k) {
        r = false;
        dfs(root, k);
        return r;
    }
}
