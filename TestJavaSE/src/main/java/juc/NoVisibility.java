package juc;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import org.junit.Test;

public class NoVisibility implements Runnable {

    private boolean ready;
    private int num=0;
    @Override
    public void run() {
        while (!ready){
//            Thread.yield();
        }
        System.out.println(num);
    }

    @Test
    public void test(){
        new Thread(this).start();
        num=100;
        ready=true;
    }
}
