package juc;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class UnModifiedTest implements Runnable{


    private Integer count= 0;

    public Integer increase(){
        count= count + 1;
        return count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(increase());
        }
    }

    public static void main(String[] args) {
        Runnable r=new UnModifiedTest();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
