package str;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */


// # 680
public class validPalindrome {


    public static void main(String[] args) {
        new validPalindrome().validPalindrome("aguokepatg" +
                                              "bnvfqmgmlc" +
                                              "upuufxoohd" +
                                              "fpgjdmysgv" +
                                              "hmvffcnqxj" +
                                              "jxqncffvmh" +
                                              "vgsymdjgpf" +
                                              "dhooxfuupu" +
                                              "culmgmqfvn" +
                                              "bgtapekouga");
        System.out.println("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga".charAt(21));
        System.out.println("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga".charAt(80));
    }
    public boolean validPalindrome(String s) {


        int low = 0, high = s.length() - 1;

        boolean valid = true;

        while (low < high) {

            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                if (!valid) { System.out.println(low+" "+high);return false;}

                //特殊处理CUUCU，这时候只能从后面删除了！
                if(s.charAt(low+1)==s.charAt(high) && s.charAt(low) == s.charAt(high-1) && s.charAt(high-2)==s.charAt(high)){
                    high--;
                }else if (s.charAt(low + 1) == s.charAt(high)) {
                    low++;
                } else if (s.charAt(low) == s.charAt(high-1)) {
                    high--;
                } else if(low+1!=high){  //对于 1231 这种情况特别处理
                    System.out.println(low+" "+high);
                    return false;
                }
                valid = false;
            }
        }
        return true;
    }
}
