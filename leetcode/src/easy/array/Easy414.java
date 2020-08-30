package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Easy414 {
    public int thirdMax(int[] nums) {
        List<Integer> max = new ArrayList<>();
        for(int n: nums) {
            addToMax(max, n);
        }
        Collections.sort(max);
        if(max.size()==3) {
            return max.get(0);
        } else {
            return max.get(max.size()-1);
        }
    }

    public void addToMax(List<Integer> max, int v) {
        if(!max.contains(v)) {
            if (max.size() ==3) {
                Integer min = Collections.min(max);
                if(v > min) {
                    max.remove(min);
                    max.add(v);
                }
            } else {
                max.add(v);
            }
        }
    }

    public static void main(String[] args) {
//        new Easy414().thirdMax(new int[] {1,2,2,5,3,5});
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
//        a.add(Integer.MIN_VALUE);
        System.out.println(Collections.min(a));
    }
}
