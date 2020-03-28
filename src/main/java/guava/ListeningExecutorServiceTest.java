package guava;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ListeningExecutorServiceTest {


    public static void main(String[] args) throws InterruptedException {
       
         /*  
          *    
        1.future 添加任务回调
          */

        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<String> explosion = service.submit(new Callable() {
            public String call() {
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "success";
            }
        });

        explosion.addListener(new Runnable() {
            @Override
            public void run() {

            }
        }, service);

        Futures.addCallback(explosion, new FutureCallback<String>() {
            // we want this handler to run immediately after we push the big red button!

            @Override
            public void onSuccess(@NullableDecl String s) {
                System.out.println(s);
            }

            public void onFailure(Throwable thrown) {
            }
        }, service);
        Thread.currentThread().join();

    }
}
