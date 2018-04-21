
/*
 *   Created by zview@qq.com on 18-4-14.
 */

public class test {


    public void pp() throws Exception {
        synchronized (p) {
            p=new Person("s");
            throw new Exception();
        }
    }

    private static Person p=new Person("静态变量");
    private  Person p1=new Person("非静态变量");

    static {
        System.out.println("静态代码快");
    }

    {
        System.out.println("非静态代码快");
    }

    public test() {
        System.out.println("test");
    }

    public static void main(String[] args) {

    }
}
