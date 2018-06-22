package str;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-19.
 */

public class PalindromePartitioningII {

    /*
    * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
    * 返回符合要求的最少分割次数。
    *
    * 首先求出任意两个位置之间是否是回文的，这样在后面就不需要对每一个范围重复计算了。可以复用前面的计算结果
    * 后面使用动态规划:
    * 1.p[i]表示i位置之前的分割次数
    * 2.
    * 3.p[j]=Min{i->是回文,p[i]+1}
    * */

    public int minCut(String s) {

        boolean isHuiWen[][] = new boolean[s.length()][s.length()];
        for (int i = 1; i < s.length(); i++) {
            isHuiWen[i][i] = true;
            isHuiWen[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }
        isHuiWen[0][0] = true;
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < i - 1; j++) {
                isHuiWen[j][i] = isHuiWen[j + 1][i - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        int p[] = new int[s.length()];
        p[0] = 1;

        //需要特别注意的是,需要判断本体是不是回文串
        for (int i = 1; i < s.length(); i++) {
            if (isHuiWen[0][i]) {
                p[i] = 1;
                continue;
            }
            p[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isHuiWen[j + 1][i]) {
                    p[i] = Math.min(p[i], p[j] + 1);
                }
            }
        }
        return p[s.length() - 1];
    }

}
