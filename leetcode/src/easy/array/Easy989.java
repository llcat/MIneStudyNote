package easy.array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Easy989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> l = new LinkedList<>();
        for(int i=A.length-1; K > 0 || i>=0; --i, K /= 10) {
            K += i >=0 ? A[i] : 0;
            l.offerFirst(K % 10);
        }
        return l;
    }

    public static void main(String[] args) {
        // [1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3]
        System.out.println(Long.MAX_VALUE);
        new Easy989().addToArrayForm(new int[] {1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3}, 516);
    }
}
