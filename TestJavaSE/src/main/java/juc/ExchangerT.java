package juc;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-24.
 */

import java.util.concurrent.Exchanger;

public class ExchangerT {


    static class Changer implements Runnable{

        private Exchanger exchanger;
        private String msg;

        public Changer(Exchanger exchanger,String msg) {
            this.exchanger = exchanger;
            this.msg=msg;
        }
        @Override
        public void run() {

            try {
                String recv= (String) exchanger.exchange(msg);
                System.out.println(Thread.currentThread().getName()+"收到了"+recv);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Exchanger<String> exchanger=new Exchanger<>();
        new Thread(new Changer(exchanger,"fh是爸爸"),"方辉").start();
        new Thread(new Changer(exchanger,"去你妈的，连状才是爸爸"),"连状").start();

    }

}
