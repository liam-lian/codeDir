package array;

/*
 *   Created by zhuang.lian@qunar.com on 18-8-3.
 */

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {

        if(nums==null||nums.length==0){
            return -1;
        }
        // left表示当前元素的左面的和
        // right表示当前元素的右面的和
        // 当前元素从0-nums.length遍历
        int left=0,right=0;
        for (int i = 1; i < nums.length; i++) {
            right+=nums[i];
        }
        if(left==right){
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            left+=nums[i-1];
            right-=nums[i];
            if(left==right){
                return i;
            }
        }
        return -1;

    }
}
