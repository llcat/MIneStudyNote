package easy.array;

public class Easy66 {
    public int[] plusOne(int[] digits) {
        boolean needAdd = false;
        for(int i=digits.length-1; i>=0; i--) {
            int d = digits[i];
            if (i== digits.length-1) {
                d = d + 1;
            }
            if(d!=0 && d%10!=0) {
                digits[i] = d;
                return digits;
            } else {
                digits[i] = 0;
                if (i-1 >=0) {
                    digits[i-1] += 1;
                } else {
                    needAdd = true;
                }
            }
        }
        if (needAdd) {
            int[] r = new int[digits.length+1];
            r[0] = 1;
            System.arraycopy(digits,0,r, 1, digits.length);
            return r;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] t = new int[] {9,9};
        new Easy66().plusOne(t);
    }
}
