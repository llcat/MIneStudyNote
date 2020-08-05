package easy.hashtable;

public class Easy1189 {
    public int maxNumberOfBalloons(String text) {
        String blo = "balloon";
        int[] map = new int[26];
        for (int i=0; i<blo.length(); i++) {
            char c = blo.charAt(i);
            map[c-'a'] = 1;
        }
        for(int i=0; i<text.length(); i++) {
            char c = text.charAt(i);
            int count = map[c-'a'];
            if (count >= 1) {
                map[c-'a'] += 1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<map.length; i++) {
            int count = map[i];
            if (count >= 1) {
                char c = (char)('a'+i);
                if (c == 'l' || c == 'o') {
                    if (min < (count-1) / 2) {
                        min = (count-1) / 2;
                    }
                } else if (min < count -1) {
                    min = count - 1;
                }
            }
        }
        return min;
    }
}
