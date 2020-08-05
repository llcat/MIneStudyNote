package easy.hashtable;

import java.util.*;

public class Easy720 {
    public String longestWord(String[] words) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i=0; i<words.length; i++) {
            set.add(words[i]);

            if (map.containsKey(words[i].length())) {
                List<String> l = map.get(words[i].length());
                l.add(words[i]);
            } else {
                List<String> l = new ArrayList<>();
                l.add(words[i]);
                map.put(words[i].length(), l);
            }
        }
        while (!map.isEmpty()) {
            List<String> l = map.pollLastEntry().getValue();
            // 保证最小字典序
            l.sort(Comparator.naturalOrder());
            for (String s:l) {
                boolean isOk = true;
                for(int i=s.length()-1; i>=1; i--) {
                    String ss = s.substring(0, i);
                    if (!set.contains(ss)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("apply");
        l.add("apple");
        l.sort(Comparator.naturalOrder());
        String s = "apply";
        String ss = s.substring(0, 1);
    }
}
