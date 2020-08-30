package easy.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  7: 0111
 *  6: 0110
 *  5: 0101
 *  4: 0100
 *  3: 0011
 */
public class Easy1356 {
    static int countBinaryBitOne(int num) {
        int count = 0;
        while (num > 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort((n1, n2) -> {
            int count1 = countBinaryBitOne(n1);
            int count2 = countBinaryBitOne(n2);
            return count1 == count2 ? Integer.compare(n1, n2) : Integer.compare(count1, count2);
        });
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        System.out.println(countBinaryBitOne(7));
    }
}
