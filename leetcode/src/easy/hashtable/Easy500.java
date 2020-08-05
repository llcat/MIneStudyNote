package easy.hashtable;

import java.util.ArrayList;
import java.util.HashSet;

public class Easy500 {
    static int[] r1 = new int[26];
    static int[] r2 = new int[26];
    static int[] r3 = new int[26];
    static boolean isGen = false;

    static void genSet() {
        if (!isGen) {
            char[] row1 = {'q','w','e','r','t','y','u','i','o','p'};
            char[] row2 = {'a','s','d','f','g','h','j','k','l'};
            char[] row3 = {'z','x','c','v','b','n','m'};
            for (char c:row1) {
                r1[c-'a'] = 1;
            }
            for (char c:row2) {
                r2[c-'a'] = 1;
            }
            for (char c:row3) {
                r3[c-'a'] = 1;
            }
            isGen = true;
        }
    }
    boolean isInOneRow(String word) {
        char[] cs = word.toLowerCase().toCharArray();
        boolean a1 = true;
        boolean a2 = true;
        boolean a3 = true;
        for (char c:cs) {
            if (r1[c-'a']!=1) {
                a1 = false;
            }
            if (r2[c-'a']!=1) {
                a2 = false;
            }
            if (r3[c-'a']!=1) {
                a3 = false;
            }
        }
        return a1 || a2 || a3;
    }

    public String[] findWords(String[] words) {
        genSet();
        ArrayList<String> r = new ArrayList<>();
        for (String s:words) {
            if (isInOneRow(s)) {
                r.add(s);
            }
        }
        return r.toArray(new String[r.size()]);
    }

    public static void main(String[] args) {
        new Easy500().isInOneRow("Abcd");
    }
}
