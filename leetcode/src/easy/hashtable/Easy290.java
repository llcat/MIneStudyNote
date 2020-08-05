package easy.hashtable;

import java.util.HashMap;

/**
 * #290 单词规律
 * 思路：与(#205判断同构字符串)是相同类型的题,
 * 若为同构，保证A -> B为唯一映射即可, 用HashMap存值判断即可
 */
public class Easy290 {
    boolean isomorphic(String[] s, String[] t) {
        if (s.length != t.length) return false;
        int length = s.length;
        HashMap<String, String> map = new HashMap<>();
        for (int i=0; i< length; i++) {
            String c1 = s[i];
            String c2 = t[i];
            if (map.containsKey(c1) && !map.get(c1).equals(c2)) {
                return false;
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }
    public boolean wordPattern(String pattern, String str) {
        String[] prr = pattern.split("");
        String[] arr = str.split(" ");
        if (arr.length != pattern.length()) return false;
        return isomorphic(prr, arr) && isomorphic(arr, prr);
    }

    public static void main(String[] args) {
        String s = "中国";
        System.out.println(s.substring(0, 1));
        new Easy290().wordPattern(""
                ,"beer");
    }
}
