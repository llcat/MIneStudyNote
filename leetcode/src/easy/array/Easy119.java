package easy.array;

import java.util.ArrayList;
import java.util.List;

public class Easy119 {
    public List<Integer> getRow(int rowIndex) {
        // 动态规划
        List<Integer> r = new ArrayList<>();
        r.add(0);
        for(int i=1; i<=rowIndex; i++) {
            for(int j=i-1; j>=1; j--) {
                int tmp = r.get(j) + r.get(j-1);
                r.set(j, tmp);
            }
        }
        return r;
    }
}
