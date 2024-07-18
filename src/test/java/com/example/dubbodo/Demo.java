package com.example.dubbodo;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyinlong
 * @since 2024/7/3 7:09 下午
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(100);
        AtomicInteger num = new AtomicInteger(1);
        // 输出偶数
        Thread threadA = new Thread(()->{
            int i = 1;
            while (i <= 100){
                if( (i %2 ) == 0){
                    System.out.println(i);
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    latch.countDown();
                }
                i++;
            }
        });
        // 输出奇数
        Thread threadB = new Thread(()-> {
            int i = 1;
            while (i <= 100) {
                if( (i %2 ) != 0) {
                    System.out.println(i);
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    latch.countDown();
                }
                i++;
            }
        });

        threadB.start();
        Thread.sleep(200);
        threadA.start();



    }


}
