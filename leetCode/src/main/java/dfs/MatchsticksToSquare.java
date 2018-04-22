package dfs;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class MatchsticksToSquare {


    public boolean makesquare(int[] nums) {

        if (nums == null || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 4 != 0) return false;
        boolean[] isVisit = new boolean[nums.length];
        return dfs(nums, isVisit, 0, 0, sum / 4, sum / 4);
    }

    private boolean dfs(int nums[], boolean[] isVist, int index, int matchEdge, int target, int edgeTarget) {

        //有一条边长度匹配成功
        if (target == 0) {
            return dfs(nums, isVist, 0, matchEdge + 1, edgeTarget, edgeTarget);
        }
        //四条边都匹配成功，才算真正的正确
        if (matchEdge == 4) {
            return true;
        }

        int j;
        for (int i = index; i < nums.length; i++) {

            if (!isVist[i] && nums[i] <= target) {
                isVist[i] = true;

                if (dfs(nums, isVist, i + 1, matchEdge, target - nums[i], edgeTarget)) {
                    isVist[i] = false;
                    return true;
                } else{
                    //如果第一个重复的位置都无法解决说明当前这个元素不应该在这里被选择,因此直接退出后面所有的可能性
                    for (j = i + 1; j < nums.length && nums[j] == nums[i]; j++) ;
                }
                isVist[i] = false;
                i = j;
            }
        }

        return false;
    }
}

