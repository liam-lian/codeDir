package juc;
/*
 *   Created by zview@qq.com on 18-4-15.
 */

import java.util.LinkedList;
import java.util.List;

/*
* 简单实现
* 基于生产这消费者模式的容器,list中可以存在的数据个数是有限的
* 当list为空,get操作阻塞,直到有数据可以取出为止
* 当list满了(达到最大的限制),put操作阻塞,直到有空位为止
* */
public class Wait_Notify {

    //使用LinkedList,基于链表,删除第一个元素更快
    final private List<Object> list = new LinkedList<>();
   //限定最大长度
    final private int MaxSize;

    public Wait_Notify(int maxSize) {
        MaxSize = maxSize;
    }

    //加锁进入函数,即每次只能有一个线程调用get或者put方法,锁加在方法上,就是获得锁才能执行方法,离开方法时自动释放锁
    //注意全文使用的都是同一把所(作用在this上的对象锁,是互斥的)
    public synchronized void put(Object item) throws InterruptedException {
        //当list满了的时候阻塞,直到收到get函数中消耗了元素之后发出的notifyAll消息为止
        while (list.size() == MaxSize) {
            //wait就是阻塞,当前的锁是作用在当前对象上的(this),调用wait函数之后,就会把持有锁释放掉,
            //之后线程进入对于this锁消息的等待队列中,直到this.notifyAll()调用之后才能唤醒
            //但是线程唤醒之后还是需要重新竞争获得锁才能继续向下执行
            //因此wait必须在获得锁之后调用
            this.wait();
        }
        list.add(item);
        //生产一个对象之后,发出通知唤醒处于等待状态的线程
        //事实上就是唤醒等在get里面的线程

        System.out.println("put--Size="+list.size());
        this.notifyAll();
    }

    public synchronized Object get() throws InterruptedException {

        /*
        * 这里使用where不能使用if,是为了避免虚假唤醒
        * 所谓虚假唤醒就是。。
        * 假设从容器为空开始：
        * Thread-A,获得锁,执行get,但是当前list为空,执行wait,释放锁,进入等待队列中.
        * 然后Thread-B,获得锁,执行get,但是当前list为空,,执行wait释放锁,也进入等待对类中.
        * 然后Thread-C,获得锁,执行put,正常执行完毕,调用了this.notifyAll()将AB两个线程唤醒
        * AB两个线程都进入Runable状态,两个线程开始竞争锁,假设B竞争到了,则B继续从刚才的this.wait()之后开始执行,消耗了一个元素,结束函数,释放锁.
        * 最后剩下A终于可以获得锁继续从this.wait()开始执行了!此时如果是if,就是直接往下走去消耗元素了,
        * 但实际上list已经空了,B应该继续等待,不应该被唤醒去往下执行,这就是虚假唤醒.
        * 改用while可以在验证一遍条件！B会继续wait
        * 因此wait必须在while中调用才安全
        * */
        while (list.size() == 0) {
            this.wait();
        }
        Object val = list.remove(0);
        //生产一个对象之后,发出通知唤醒处于等待状态的线程
        //事实上就是唤醒等在set里面的线程
        this.notifyAll();
        System.out.println("get--Size="+list.size());
        return val;
    }

    //主函数测试
    public static void main(String[] args) {

        Wait_Notify container=new Wait_Notify(10);

        Runnable producer=new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        container.put(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer=new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        container.get();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //开启三个消费者三个生产者
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}



/*
* 执行结果
* put--Size=1
get--Size=0
put--Size=1
put--Size=2
put--Size=3
put--Size=4
put--Size=5
put--Size=6
put--Size=7
put--Size=8
put--Size=9
get--Size=8
get--Size=7
get--Size=6
get--Size=5
get--Size=4
get--Size=3
get--Size=2
get--Size=1
get--Size=0
put--Size=1
put--Size=2
put--Size=3
put--Size=4
put--Size=5
put--Size=6
put--Size=7
put--Size=8
put--Size=9
put--Size=10
get--Size=9
get--Size=8
get--Size=7
get--Size=6
get--Size=5
get--Size=4
get--Size=3
get--Size=2
get--Size=1
get--Size=0
put--Size=1
put--Size=2
put--Size=3
put--Size=4
put--Size=5
put--Size=6
put--Size=7
put--Size=8
put--Size=9
put--Size=10
get--Size=9
get--Size=8
get--Size=7
get--Size=6
get--Size=5
get--Size=4
get--Size=3
get--Size=2
get--Size=1
get--Size=0
*
* */