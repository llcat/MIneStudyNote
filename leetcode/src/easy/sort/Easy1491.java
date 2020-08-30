package easy.sort;

public class Easy1491 {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int count = 0;
        // 找出最大最小值
        for(int num:salary) {
            count+=num;
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return (count-min-max)/(double)(salary.length-2);
    }
}
