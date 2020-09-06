package easy.array;

public class Easy941 {
    public boolean validMountainArray(int[] A) {
        boolean hasPeak = false;
        for(int i=0; i<A.length-1; i++) {
            if (i-1 >=0 && i+1 <= A.length-1) {
                if (A[i-1] < A[i] && A[i] > A[i+1]) {
                    hasPeak = true;
                }
            }
            if (!hasPeak) {
                if (A[i+1] <= A[i]) return false;
            } else {
                if (A[i+1] >= A[i]) return false;
            }
        }
        return hasPeak;
    }

    public static void main(String[] args) {
        int[] t = new int[] {0,2,3,4,5,2,1,0};
        new Easy941().validMountainArray(t);
    }
}
