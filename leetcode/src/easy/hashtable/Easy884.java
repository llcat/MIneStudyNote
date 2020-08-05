package easy.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Easy884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] Arr = A.split(" ");
        String[] Brr = B.split(" ");
        HashMap<String, Integer> m1 = new HashMap<>();
        HashMap<String, Integer> m2 = new HashMap<>();
        for (String s:Arr) {
            m1.put(s, m1.getOrDefault(s,0) + 1);
        }
        for (String s:Brr) {
            m2.put(s, m2.getOrDefault(s,0) + 1);
        }
        List<String> r = new ArrayList<>();
        for(String k1:m1.keySet()) {
            if (m1.get(k1) == 1 && m2.getOrDefault(k1, 0) ==0) {
                r.add(k1);
            }
        }
        for(String k2:m2.keySet()) {
            if (m2.get(k2) == 1 && m1.getOrDefault(k2, 0) ==0) {
                r.add(k2);
            }
        }
        return r.toArray(new String[r.size()]);
    }
}
