package easy.hashtable;

import java.util.*;

public class Easy748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String lowercasePlate = licensePlate.toLowerCase();
        int maxBound = 'z' - '0';
        int minBound = 'a' - '0';
        List<Character> l = new ArrayList<>();
        for (char c:lowercasePlate.toCharArray()) {
            int delta = c - '0';
            if (delta >= minBound && delta <= maxBound) {
                l.add(c);
            }
        }
        String w = null;
        for (int i=0; i<words.length; i++) {
            List<Character> copyL = new ArrayList<>();
            for (Character ch:l) {
                copyL.add(ch);
            }
            String word = words[i];
            for (char c:word.toCharArray()) {
                copyL.remove(new Character(c));
            }
            if (copyL.size() == 0) {
                if (w == null) {
                    w = word;
                }
                if (word.length() < w.length()) {
                    w = word;
                }
            }
        }
        return w;
    }

    public static void main(String[] args) {
        System.out.println("1Ss3Pam".toLowerCase());
        System.out.println('z'-'0');
        // "1s3 456"
// ["looks","pest","stew","show"]
        new Easy748().shortestCompletingWord("1s3 456",
                new String[]{"looks","pest","stew","show"});
    }
}
