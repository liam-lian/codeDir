
/*
 *   Created by zview@qq.com on 18-4-14.
 */

public class test {


    public static void main(String[] args) throws InterruptedException {

        Thread t=new Thread(()->{
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                System.out.println("线程中断");
                e.printStackTrace();
            }
        });

        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}
