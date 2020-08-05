package easy.hashtable;

public class Easy1160 {
    int[] makeMap(String chars) {
        int[] map = new int[26];
        for(char c : chars.toCharArray()) {
            map[c-'a'] += 1;
        }
        return map;
    }
    public int countCharacters(String[] words, String chars) {
        int r = 0;
        for (String w:words) {
            boolean isOk = true;
            int[] map = makeMap(chars);
            for (char c : w.toCharArray()) {
                int count = map[c-'a'] - 1;
                map[c-'a'] = count;
                if (count < 0) {
                    isOk = false;
                }
            }
            if(isOk) {
                r += w.length();
            }
        }
        return r;
    }
}
