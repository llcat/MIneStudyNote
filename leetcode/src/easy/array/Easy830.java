package easy.array;

import java.util.ArrayList;
import java.util.List;

public class Easy830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        int index = 0;
        int count = 1;
        char pre = S.charAt(0);
        List<List<Integer>> r = new ArrayList<>();
        for(int i=1; i<S.length(); i++) {
            char cur = S.charAt(i);
            if (cur != pre) {
                // 添加结果
                if (count >= 3) {
                    List<Integer> item = new ArrayList<>();
                    item.add(index);
                    item.add(index + count - 1);
                    r.add(item);
                }
                index = i;
                count = 1;
            } else {
                count += 1;
                // 处理特殊情况
                if (count >=3 && i==S.length()-1) {
                    List<Integer> item = new ArrayList<>();
                    item.add(index);
                    item.add(index + count - 1);
                    r.add(item);
                }
            }
            pre = cur;
        }
        return r;
    }
}
