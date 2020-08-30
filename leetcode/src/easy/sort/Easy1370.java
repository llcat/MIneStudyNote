package easy.sort;

public class Easy1370 {
    public String sortString(String s) {
        int[] map = new int[26];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map[c-'a'] += 1;
        }
        boolean isEmpty = true;
        boolean asc = true;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < map.length && index > -1) {
            if(map[index] > 0) {
                sb.append((char)('a'+index));
                map[index] -= 1;
            }
            isEmpty = isEmpty && map[index] == 0;
            if (asc) {
                index++;
            } else {
                index--;
            }
            if (index == map.length && !isEmpty) {
                isEmpty = true;
                asc = false;
                index = map.length - 1;
            }
            if (index == -1 && !isEmpty) {
                isEmpty = true;
                asc = true;
                index = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Easy1370().sortString("aaaabbbbcccc");
    }
}
