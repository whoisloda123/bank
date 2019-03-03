package com.liucan.multthread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏
 * 所有线程必须在栅栏旁边等待其他线程，直到所有线程到达才能继续做其他事情
 * 可以通过传入参数设置所有线程到达栅栏后执行一个Runnable
 *
 * @author liucan
 * @version 19-3-3
 */
public class CyclicBarrier1 {

    public void test() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println("2个线程都同时到达了"));

        new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("cyclicBarrier:thread1执行了");
                cyclicBarrier.await();
                System.out.println("cyclicBarrier:thread1执行了，继续执行剩下的");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("cyclicBarrier:thread2执行了");
                cyclicBarrier.await();
                System.out.println("cyclicBarrier:thread2执行了，继续执行剩下的");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
