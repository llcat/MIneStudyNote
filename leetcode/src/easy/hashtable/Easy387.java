package easy.hashtable;

public class Easy387 {
    public int firstUniqChar(String s) {
        int[] mapR = new int[26];
        int l = s.length();
        for (int i=0; i< l; i++) {
            char c = s.charAt(i);
            mapR[c-'a'] += 1;
        }
        for (int i=0; i< l; i++) {
            char c = s.charAt(i);
            if (mapR[c-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char a = 'z';
        System.out.println(a-'a');
    }
}
