package dp;
/*
 *   Created by zview@qq.com on 18-4-22.
 */



public class CoinChange {

    /*
    * 动态规划
    * dp[i][j]表示当前仅仅只使用前i中钱币的情况下,凑成j元有多少种方法
    * 则dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]]
    * 1. 使用前i-1种货币的种数
    * 2. 使用了第i种货币的种数==>转化为首先确保至少使用一张(总额变为j-coins[i]),然后在递归计算.
    * */


    public int change(int amount, int[] coins) {


        int dp[][]=new int[coins.length+1][amount+1];
        dp[0][0]=1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0]=1;
            for (int j = 1; j < amount+1; j++) {
                if(j>=coins[i+1]){
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i+1]];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount];
    }

    /*
    * 事实上并不需要二维数组,只需要一维数组保存中间结果即可
    * 因为[i][j]只与上一行和当前行前面的元素有关,可以复用
    * */

    public int change_modify(int amount, int[] coins) {


        int dp[]=new int[amount+1];
        dp[0]=1;  //这里是重要的初始化条件
        for (int coin : coins) {
            for (int j = 1; j < amount + 1; j++) {
                if (j > coin) {
                    dp[j] += dp[j - coin];
                }
            }
        }
        return dp[amount];
    }
}
