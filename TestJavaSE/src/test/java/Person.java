
/*
 *   Created by zview@qq.com on 18-4-14.
 */

import java.io.*;
import java.util.concurrent.*;

public class Person {

    private int name;

    public Person(String info) {
        System.out.println("person  "+info);
    }

    public static void main(String[] args) {


        ExecutorService exec=Executors.newSingleThreadExecutor();
        Future ft=  exec.submit(()-> {
            try {
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        ft.cancel(true);
        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void doo(final Person p) throws FileNotFoundException, UnsupportedEncodingException {
        p.name=1;
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream("filename"),"UTF-8"));
    }
}




