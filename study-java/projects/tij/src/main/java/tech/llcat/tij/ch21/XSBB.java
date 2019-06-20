package tech.llcat.tij.ch21;


public class XSBB implements Runnable {
    private static int counter = 0;

    private final int id = counter++;

    public XSBB(){
        System.out.println("XSBB"+id+" on constructor");
    }

    @Override
    public void run() {
        System.out.println("XSBB"+id+": aa");
        Thread.yield();
        System.out.println("XSBB"+id+": bb");
        Thread.yield();
        System.out.println("XSBB"+id+": cc");
        Thread.yield();
    }

    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            new Thread(new XSBB()).start();
            System.out.println(i);
        }
    }
}
