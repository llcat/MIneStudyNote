package easy.array;

public class Easy717 {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        for(int i=0; i<bits.length; i=index) {
            int bit = bits[i];
            if(bit == 1) {
                index = index+2;
            }
            if(bit == 0) {
                index = index+1;
            }
            if(i==bits.length-1 && bit==0) {
                return true;
            }
        }
        return false;
    }
}
