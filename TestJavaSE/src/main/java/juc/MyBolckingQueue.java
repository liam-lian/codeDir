package juc;

/*
 *   Created by zview@qq.com on 18-4-15.
 */

/*
* 这个类是一个实现了生产者消费者模式的队列
* 队列使用了循环数组的来实现
* 在构造方法中指定了队列的最大大小
* */

public class MyBolckingQueue {

    private final Object[] data;

    //队列尾部要插入的数据的位置(当前队列第一个没有数据的位置)
    private int putIndex;
    //队列头部取出元素的位置
    private int getIndex;
    //队列中有效数据的个数
    private int count;

    public MyBolckingQueue(int size) {
        this.data = new Object[size];
    }

    public synchronized void put(int item) throws InterruptedException {

        while (count == data.length) {
            this.wait();
        }
        data[putIndex++] = item;
        if(putIndex==data.length) putIndex=0;
        count++;
        this.notifyAll();
        System.out.println("put:"+count);
    }

    public synchronized Object get() throws InterruptedException {

        while (count == 0) {
            this.wait();
        }
        Object val = data[getIndex++];
        if(getIndex==data.length) getIndex=0;
        count--;
        this.notifyAll();
        System.out.println("get:"+count);
        return val;
    }

    public static void main(String[] args) {
        MyBolckingQueue q = new MyBolckingQueue(10);

        Runnable p = () -> {
            for (int i = 0; i < 20; i++) {

                try {
                    q.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Runnable c = () -> {
            for (int i = 0; i < 20; i++) {
                try {
                    q.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(c).start();
        new Thread(c).start();
        new Thread(c).start();
        new Thread(c).start();
        new Thread(c).start();
    }
}
