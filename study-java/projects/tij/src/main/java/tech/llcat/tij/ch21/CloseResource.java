package tech.llcat.tij.ch21;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CloseResource {
    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8888);
        InputStream socketInput = new Socket("localhost", 8888).getInputStream();
        es.execute(new IOBlocked(socketInput));
        es.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Shutting down all threads");
        es.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing "+socketInput.getClass().getSimpleName());
        socketInput.close();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing "+System.in.getClass().getSimpleName());
        System.in.close();
    }
}
