package easy.array;

import java.util.Arrays;

public class Easy1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        int part = 0;
        int cnt = 0;
        int average = sum / 3;
        if (sum % 3 != 0) return false;
        for(int n : A) {
            part += n;
            if (part == average) {
                cnt += 1;
                part = 0;
            }
            if (cnt == 3) return true;
        }
        return false;
    }
}
