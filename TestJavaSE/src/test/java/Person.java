
/*
 *   Created by zview@qq.com on 18-4-14.
 */

import java.io.*;

public class Person {

    private int name;

    public Person(String info) {
        System.out.println("person  "+info);
    }

    public static void main(String[] args) {
       Person p=new Person("sss");

        System.out.println(p.name);

    }

    public static void doo(final Person p) throws FileNotFoundException, UnsupportedEncodingException {
        p.name=1;
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream("filename"),"UTF-8"));
    }
}




