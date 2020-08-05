package easy.hashtable;

public class Easy299 {
    public String getHint(String secret, String guess) {
        int[] mapS = new int[10];
        int[] mapG = new int[10];
        int A = 0;
        for (int i=0; i<secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                A++;
            } else {
                mapS[s-'0'] += 1;
                mapG[g-'0'] += 1;
            }
        }
        int B = 0;
        for (int i=0; i<mapS.length; i++) {
            B += Math.min(mapS[i], mapG[i]);
        }
        return A+"A"+B+"B";
    }

    public static void main(String[] args) {
        char i = '9';
        System.out.println(i - '0');
    }
}
