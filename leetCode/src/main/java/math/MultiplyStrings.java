package math;

/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */


import org.junit.Test;

/*
 * 大数乘法
 * */
public class MultiplyStrings {

    @Test
    public void test() {
        System.out.println(multiply("1223123123123123123123123123123123123", "12"));
    }

    public String multiply(String num1, String num2) {


        //如果确定是int表达范围以内的运算，直接计算即可
        if (num1.length() + num2.length() <= 9) {
            return String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));
        }

        //num1倒序存放
        int[] num1Int = new int[num1.length()];
        //num2倒序存放
        int[] num2Int = new int[num2.length()];
        //存放结果,结果最大的位数就是num1和num2的位数之和
        int[] res = new int[num1.length() + num2.length() + 1];
        for (int i = num1.length() - 1, index = 0; i >= 0; i--) {
            num1Int[index++] = num1.charAt(i) - '0';
        }
        for (int i = num2.length() - 1, index = 0; i >= 0; i--) {
            num2Int[index++] = num2.charAt(i) - '0';
        }

        // 注意i和j为相乘的结果就放在第i+j位,模拟了手动计算的过程
        for (int i = 0; i < num1Int.length; i++) {
            for (int j = 0; j < num2Int.length; j++) {
                res[i + j] += num1Int[i] * num2Int[j];
            }
        }
        //处理进位信息
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 9) {
                res[i + 1] += res[i] / 10;
                res[i] = res[i] % 10;
            }
        }

        //去除全部的前导0(最后一位除外,index=0时表示运算结果就是0)
        int index = res.length - 1;
        while (index >0 && res[index] == 0) {
            index--;
        }

        StringBuilder ressb = new StringBuilder();
        for (int i = index; i >= 0; i--) {
            ressb.append(res[i]);
        }

        return ressb.toString();
    }
}
