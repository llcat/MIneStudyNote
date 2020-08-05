package easy.hashtable;

public class Easy953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for(int i=0; i<order.length(); i++) {
            char c = order.charAt(i);
            index[c-'a'] = i;
        }
        for(int i=0; i<words.length-1; i++) {
            String pre = words[i];
            String next = words[i+1];
            int minSize = Math.min(pre.length(), next.length());
            char c1 = '0';
            char c2 = '1';
            for (int j=0; j<minSize; j++) {
                c1 = pre.charAt(j);
                c2 = next.charAt(j);
                int idx1 = index[c1 - 'a'];
                int idx2 = index[c2 - 'a'];
                if (idx1 < idx2) {
                    break;
                }
                if (c1!=c2 && idx1 > idx2) {
                    return false;
                }
            }
            if (c1 == c2 && pre.length() > next.length()) return false;
        }
        return true;
    }

    /**
     * ["kuvp","q"]
     "ngxlkthsjuoqcpavbfdermiywz"
     * @param args
     */
    public static void main(String[] args) {
        new Easy953().isAlienSorted(new String[] {"kuvp","q"},"ngxlkthsjuoqcpavbfdermiywz");
    }
}
