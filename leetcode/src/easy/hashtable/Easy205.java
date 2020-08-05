package easy.hashtable;

import java.util.HashMap;

public class Easy205 {
    boolean isomorphic(String s, String t) {
        int length = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i=0; i< length; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        return isomorphic(s, t) && isomorphic(t, s);
    }
}
