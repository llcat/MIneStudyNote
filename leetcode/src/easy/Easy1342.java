package easy;

public class Easy1342 {
    public int numberOfSteps (int num) {
        if (num == 0) {
            return 0;
        }
        int nextNum = 0;
        if (num % 2 == 0) {
            nextNum = num / 2;
        } else {
            nextNum = num - 1;
        }
        return 1 + numberOfSteps(nextNum);
    }

    public static void main(String[] args) {
        int count = new Easy1342().numberOfSteps(4);
        System.out.println(count);
    }
}
