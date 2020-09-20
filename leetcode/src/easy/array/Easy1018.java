package easy.array;

import java.util.ArrayList;
import java.util.List;

public class Easy1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> l = new ArrayList<>();
        int num = 0;
        for(int n : A) {
            num = ((num << 1) + n) % 5;
            l.add(num == 0);
        }
        return l;
    }

    public static void main(String[] args) {
//        int[] t = new int[] {1,1,0,0,0,1,0,0,1};
        int[] t = new int[] {
                1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1
        };
        new Easy1018().prefixesDivBy5(t);
    }
}
