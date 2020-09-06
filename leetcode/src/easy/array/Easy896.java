package easy.array;

public class Easy896 {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 1) return true;
        Boolean preOrder = null;
        for(int i=0; i<A.length-1; i++) {
            if (A[i] == A[i+1]) continue;
            boolean curOrder = A[i] < A[i+1];
            if (preOrder != null && preOrder != curOrder) {
                return false;
            }
            preOrder = curOrder;
        }
        return true;
    }
}
