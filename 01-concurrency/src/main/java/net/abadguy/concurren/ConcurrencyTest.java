package net.abadguy.concurren;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @ClassName:
 * @Description: 代码模拟并发模拟
 * @date: 2019/6/113:03
 */
@Slf4j
public class ConcurrencyTest {

    /* 请求总数*/
    public static int clientTotal=5000;
    /*同时并发执行的线程数*/
    public static int threadTotal=200;

    public static int count=0;

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(threadTotal);
        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    add();
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
        log.info("count:{}",count);
    }

    private static void add(){
        count++;
    }
}
