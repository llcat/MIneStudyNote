package easy.sort;

public class Easy922 {
    public int[] sortArrayByParityII(int[] A) {
        int oddIndex = 1;
        int evenIndex = 0;
        int[] r = new int[A.length];
        for(int num: A) {
            if(num % 2 == 0) {
                r[evenIndex] = num;
                evenIndex += 2;
            } else {
                r[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return r;
    }
}
