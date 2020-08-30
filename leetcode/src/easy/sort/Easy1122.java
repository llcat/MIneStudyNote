package easy.sort;

public class Easy1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        // 按序记录arr1
        for(int n1:arr1) {
            count[n1] += 1;
        }
        // arr2一定在arr1中, 按arr2的顺序和记录的count重写arr1
        int index = 0;
        for(int n2:arr2) {
            while (count[n2] > 0) {
                arr1[index] = n2;
                index++;
                count[n2]--;
            }
        }
        // 将剩余的值按序插入到arr1
        for(int i=0; i<count.length; i++) {
            while (count[i] > 0) {
                arr1[index] = i;
                index++;
                count[i]--;
            }
        }
        return arr1;
    }
}
