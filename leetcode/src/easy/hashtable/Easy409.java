package easy.hashtable;

import java.util.Arrays;

public class Easy409 {
    public int longestPalindrome(String s) {
        int[] mapR = new int[('z'-'A')+1];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            mapR[c-'A'] += 1;
        }
//        Arrays.sort(mapR);
        boolean hasOdd = false;
        int sum = 0;
        for(int i=mapR.length-1; i>=0; i--) {
            if (mapR[i] % 2 != 0) {
                hasOdd = true;
                sum += mapR[i] - 1;
            } else {
                sum += mapR[i];
            }
        }
        if (hasOdd) {
            sum += 1;
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println('a'-'Z');
        new Easy409().longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez");
    }
}
