package main.java.math;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class ArithmeticSlices {


    public int numberOfArithmeticSlices(int[] A) {
        
        int res=0;
        int lastDiff=A[1]-A[0];
        int curLen=0;
        for (int i = 2; i < A.length; i++) {
            if(A[i]-A[i-1]==lastDiff) curLen++;
            else{
                res+=getLen(curLen);
                curLen=0;
                lastDiff=A[i]-A[i-1];
            }
        }
        res+=getLen(curLen);
        return res;
    }

    private int getLen(int n){
        int res=0;
        for (int i = 0; i < n; i++) {
            res+=i;
        }
        return res;
    }
}
