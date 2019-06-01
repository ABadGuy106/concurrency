package net.abadguy.example.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName:
 * @Description: 代码模拟并发模拟---线程安全
 * @date: 2019/6/113:03
 */
@Slf4j

public class AtomicExample2 {

    /* 请求总数*/
    public static int clientTotal=5000;
    /*同时并发执行的线程数*/
    public static int threadTotal=200;

    public static AtomicLong count=new AtomicLong(0);

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
        log.info("count:{}",count.get());
    }

    private static void add(){
        //先做增加操作在获取当前值
        count.incrementAndGet();
        //先获取当前值在做增加操作
        //count.getAndIncrement();
    }
}
