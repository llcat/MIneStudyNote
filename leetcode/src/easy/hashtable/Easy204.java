package easy.hashtable;

import java.util.Arrays;

public class Easy204 {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] filter = new boolean[n];
        Arrays.fill(filter, true);
        for (int i=2; i*i <= n; i++) {
            if (filter[i]) {
                for (int j=i*i; j<n; j+=i) {
                    filter[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++)
            if (filter[i]) count++;

        return count;
    }

    public static void main(String[] args) {
        boolean[] a = new boolean[20];
        System.out.println(a[0]);
    }
}
