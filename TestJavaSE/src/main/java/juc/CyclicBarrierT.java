package juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.DelayQueue;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-24.
 */
public class CyclicBarrierT {
    static class NextStop implements Runnable{

        private CyclicBarrier barrier;

        public NextStop(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        @Override
        public void run() {
            try {
                System.out.println("玩家"+Thread.currentThread().getName()+"正在第一关");
                Thread.sleep(new Random().nextInt(1500) + 500);
                System.out.println("玩家"+Thread.currentThread().getName()+"结束第一关");
                barrier.await();
                System.out.println("玩家"+Thread.currentThread().getName()+"进入第二关");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        CyclicBarrier barrier=new CyclicBarrier(4,()->{
            System.out.println("所有玩家都已经完成第一关,最后一个完成的是:玩家"+Thread.currentThread().getName());
        });

        for (int i = 0; i < 4; i++) {
            new Thread(new NextStop(barrier),String.valueOf(i)).start();
        }
    }
}
