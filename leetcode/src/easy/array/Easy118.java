package easy.array;

import java.util.ArrayList;
import java.util.List;

public class Easy118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<>();
        for (int i=1; i<=numRows; i++) {
            int[] temp = new int[i];
            temp[0] = 1;
            temp[i-1] = 1;
            if(!r.isEmpty()) {
                List<Integer> l = r.get(i-2);
                for(int k=0; k<l.size()-1; k++) {
                    int pre = l.get(k);
                    int next = l.get(k+1);
                    temp[k+1] = pre + next;
                }
                List<Integer> next = new ArrayList<>();
                for(int t: temp) {
                    next.add(t);
                }
                r.add(next);
            } else {
                List<Integer> l = new ArrayList<>();
                for(int n: temp) {
                    l.add(n);
                }
                r.add(l);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        new Easy118().generate(5);
    }
}
