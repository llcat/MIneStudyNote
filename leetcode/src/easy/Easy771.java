package easy;
import java.util.Arrays;
import java.util.HashSet;

public class Easy771 {
    public int numJewelsInStones(String J, String S) {
        String[] jStones = J.split("");
        String[] sStones = S.split("");
        HashSet<String> set = new HashSet<>(Arrays.asList(jStones));
        int count = 0;
        for(String s : sStones) {
            if (set.contains(s)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new Easy771().numJewelsInStones("aA", "aaBBAA");
    }
}
