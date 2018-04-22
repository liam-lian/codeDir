package math;
/*
 *   Created by zview@qq.com on 18-4-13.
 */

public class PowxN {

    /*
    * 分治法,每次计算一半
    * 注意当n为负数时候的处理
    * */
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n==-1) return 1/x;

        double half=myPow(x,n/2);
        if(n%2==0) return half*half;
        if(n<0) return half*half/x;
        return half*half*x;
    }
}
