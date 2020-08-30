package easy.array;

public class Easy167 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (numbers[low] + numbers[high] != target) {
            if (numbers[low] + numbers[high] > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[] {low+1,high+1};
    }

    public int[] twoSum1(int[] numbers, int target) {
        int[] r = new int[2];
        for(int i=0; i<numbers.length; i++) {
            r[0] = i+1;
            int left = target - numbers[i];
            for(int j=i+1; j<numbers.length; j++) {
                if(left == numbers[j]) {
                    r[1] = j+1;
                    return r;
                } else if(left < numbers[j]) {
                    break;
                }
            }
        }
        return r;
    }
}
