package easy.hashtable;

import java.util.ArrayList;
import java.util.List;

public class Easy1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> r = new ArrayList<>();
        for(int i=0; i<words.length-1; i++) {
            String f = words[i];
            String n = words[i+1];
            if (f.equals(first) && n.equals(second)) {
                if (i+2 < words.length) {
                    r.add(words[i+2]);
                }
            }
        }
        return r.toArray(new String[r.size()]);
    }
}
