package easy.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Easy811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String cpdomain:cpdomains) {
            String[] ss = cpdomain.split(" ");
            int count = Integer.parseInt(ss[0], 10);
            String domain = ss[1];
            map.put(domain, map.getOrDefault(domain,0)+count);
            int index = domain.indexOf(".");
            while (index != -1) {
                domain = domain.substring(index+1);
                map.put(domain, map.getOrDefault(domain,0)+count);
                index = domain.indexOf(".");
            }
        }
        List<String> r = new ArrayList<>();
        for (String key:map.keySet()) {
            String item = map.get(key) + " " + key;
            r.add(item);
        }
        return r;
    }

    public static void main(String[] args) {
        String s = "99 aa.bb.com";
        String[] sr = s.split(" ");
        int index = s.indexOf(".");
        String ss = s.substring(index+1);
    }
}
