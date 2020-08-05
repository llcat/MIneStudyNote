package easy.hashtable;

import java.util.ArrayList;
import java.util.List;

public class Easy1002 {
    public List<String> commonChars(String[] A) {
        int[][] map = new int[A.length][26];
        for(int row = 0; row<A.length; row++) {
            String s = A[row];
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                map[row][c-'a'] += 1;
            }
        }
        List<String> r = new ArrayList<>();
        for (int i=0; i<26; i++) {
            char c = (char)('a' + i);
            int minCount = Integer.MAX_VALUE;
            for(int j=0; j<A.length; j++) {
                if (map[j][i] < minCount) {
                    minCount = map[j][i];
                }
            }
            if (minCount > 0) {
                int repeat = minCount;
                while (repeat !=0) {
                    r.add(""+c);
                    repeat--;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
//        int a = new int[2][16].length;
        new Easy1002().commonChars(new String[] {"bella","label","roller"});
    }
}
