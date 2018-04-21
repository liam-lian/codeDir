package dfs;

/*
 *   Created by zview@qq.com on 2018/4/19.
 */
public class CoinChange_ii {

    private int[] coins;
    private int res;

    public int change(int amount, int[] coins) {
        this.coins=coins;
        dfs(0,0,amount);
        return res;
    }

    private void  dfs(int index,int sum,int amount){

        if(sum==amount){
            res++;
            return;
        }
        if(sum>amount || index>=coins.length){
            return;
        }

        dfs(index,sum+coins[index],amount);
        dfs(index+1,sum,amount);
    }
}
