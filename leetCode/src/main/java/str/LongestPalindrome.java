package str;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-19.
 */

public class LongestPalindrome {

    /*
    * Manacher算法求最长的回文子串
    * 这个算法首先讲字符串转化为奇数长度
    * 然后利用已知的回文串的两侧是对称的这种特性，来将前面的计算结果复用在后面
    * */

    public String longestPalindrome(String s) {


        StringBuilder builder = new StringBuilder();
        builder.append('#');
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            builder.append('#');
        }
        s = builder.toString();

        // len[i]表示的是以i为中心的最长的Palindrome串的长度
        int len[] = new int[s.length()];

        //id--当前最长Palindrome串的中心index
        //barrier当前能够到达的最远的位置+1
        int id = 0, barrier = 0;
        int maxId = 0;

        for (int i = 0; i < s.length(); i++) {

            if (i < barrier) {
                len[i] = Math.min(barrier - i, len[2 * id - i]);
            } else {
                len[i] = 1;
            }
            while (i - len[i] >= 0 && i + len[i] < s.length() && s.charAt(i - len[i]) == s.charAt(i + len[i])) {
                len[i]++;
            }

            if (i + len[i] > barrier) {
                barrier = i + len[i];
                id = i;
            }
            if (len[i] > len[maxId]) {
                maxId = i;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = maxId - len[maxId] + 2; i < maxId + len[maxId]; i += 2) {
            res.append(s.charAt(i));
        }

        return res.toString();
    }
}
