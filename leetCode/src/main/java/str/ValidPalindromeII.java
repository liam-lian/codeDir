package str;
/*
 *   Created by zview@qq.com on 18-4-14.
 */


/*
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * */

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        return valid(s,0,s.length()-1,false);
    }

    //hasDelete判断是否已经删除过一个元素了
    //也就是这个递归最多深度只有一层，写成递归是为了方便
    private boolean valid(String s, int start, int end ,boolean hasDelete) {

        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        if (start >= end) return true;
        if(hasDelete) return false;
        return valid(s, start + 1, end,true) || valid(s, start, end - 1,true);
    }
}
