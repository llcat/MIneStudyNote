package tech.llcat.tij.ch19;

import java.util.Random;

interface Generator<T>{
    T next();
}
// enum可以实现接口
enum CartoonCharacter implements Generator<CartoonCharacter>{
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random rand = new Random(47);
    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }

    public static CartoonCharacter nn(){
        Random rand = new Random(47);
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static void printNext(Generator generator){
        System.out.println(generator.next());
    }
    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for(int i=0; i<10; i++){
            printNext(cc);
        }
    }
}


