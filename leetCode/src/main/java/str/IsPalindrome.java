package str;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-19.
 */

public class IsPalindrome {
    /*
    * #125 验证一下是不是回文串
    * */

    public boolean isPalindrome(String s) {

        int l = 0, r = s.length() - 1;

        while (l < r) {

            while (l < r && isValid(s.charAt(l))) {
                l++;
            }

            while (l < r && isValid(s.charAt(r))) {
                r--;
            }
            if (Character.toUpperCase(s.charAt(l)) != Character.toUpperCase(s.charAt(r))) {
                return false;
            }
            // 这里的两条不要漏掉了
            l++;
            r--;
        }
        return true;
    }

    private boolean isValid(char c) {
        return !(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9');
    }

}
