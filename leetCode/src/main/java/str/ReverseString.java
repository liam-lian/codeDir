package str;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class ReverseString {

    public String reverseString(String s) {


        char[] val=s.toCharArray();
        int n=val.length-1;
        int left=(n-1)>>1;
        int right;

        while (left>=0){
            right=n-left;
            char temp=val[left];
            val[left]=val[right];
            val[right]=temp;
            left--;
        }
        return new String(val);
    }
}
