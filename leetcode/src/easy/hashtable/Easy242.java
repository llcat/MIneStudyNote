package easy.hashtable;

import java.util.HashMap;

/**
 * #242 有效的字母异位词
 * 思路：同时遍历两字符串, 第一个字串遍历字符时Map存值加一
 * 第二个字符串遍历字符时Map存值减一，遍历Map.values()判断有无非0情况，有为异位词
 */
public class Easy242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            Character c1 = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) -1);
            } else {
                map.put(c1, -1);
            }
        }
        for (int n : map.values()) {
            if (n != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Easy242().isAnagram("a", "b");
    }
}
