package easy.sort;

public class Easy1528 {
    public String restoreString(String s, int[] indices) {
        int[] map = new int[indices.length];
        for(int i=0; i<s.length(); i++) {
            map[indices[i]] = s.charAt(i) - 'a';
        }
        StringBuilder sb = new StringBuilder();
        for(int n:map) {
            sb.append((char)(n+'a'));
        }
        return sb.toString();
    }
}
