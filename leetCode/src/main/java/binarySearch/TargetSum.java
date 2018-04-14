package binarySearch;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class TargetSum {

    private int res;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,S,0,0);
        return res;
    }

    private void dfs(int nums[], int S, int index, int sum) {
        if (index == nums.length) {
            if (sum == S)
                res++;
            return;
        }
        dfs(nums,S,index+1,sum+nums[index]);
        dfs(nums,S,index+1,sum-nums[index]);
    }


}
