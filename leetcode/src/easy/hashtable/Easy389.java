package easy.hashtable;

import java.util.HashSet;

public class Easy389 {
    public char findTheDifference(String s, String t) {
        String all = s + t;
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<all.length(); i++) {
            char c = all.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.iterator().next();
    }
}
