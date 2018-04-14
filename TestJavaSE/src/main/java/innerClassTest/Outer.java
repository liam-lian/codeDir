package innerClassTest;
/*
 *   Created by zview@qq.com on 18-4-14.
 */

public class Outer {

    //返回一个内部类
    public Runnable getRunnable(){
        class RunInstance implements Runnable{
            @Override
            public void run() {
                System.out.println("run");
            }
        }
        return new RunInstance();
    }

    public int cal(int n){
        class Inner{
            private int n;
            private Inner(int n) {
                this.n = n;
            }
            private int cal(){
                int res=0;
                for (int i = 0; i < n; i++) {
                    res+=i;
                }
                return res;
            }
        }
        return new Inner(n).cal();
    }
}
