package net.abadguy.example.common.unsafe;

import lombok.extern.slf4j.Slf4j;
import net.abadguy.annoations.NotThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * StringBuilder是线程不安全的类
 */
@Slf4j
@NotThreadSafe
public class StringExample2 {

    /* 请求总数*/
    public static int clientTotal=5000;
    /*同时并发执行的线程数*/
    public static int threadTotal=200;

    public static StringBuffer stringBuffer=new StringBuffer();

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(threadTotal);
        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        log.info("size:{}",stringBuffer.length());
    }

    private static void update(){
        stringBuffer.append("1");
    }
}
