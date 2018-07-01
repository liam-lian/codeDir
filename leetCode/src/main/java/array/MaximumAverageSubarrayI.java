package array;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-25.
 */
public class MaximumAverageSubarrayI {

    /*
    * 其实相当于一个长度为k的窗口了在不断的移动
    * 新的窗口的和等于旧的窗口的和加上diff。
    * diff>0 的时候才可能有新的最大和的出现
    * */
    public double findMaxAverage(int[] nums, int k) {

        int sum=0;
        int max;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        max=sum;
        int diff;

        for (int i = k; i < nums.length; i++) {
            diff=nums[i]-nums[i-k];
            sum+=diff;
            if(diff>0){
                max=Math.max(max,sum);
            }
        }

        return ((double)max)/k;
    }
}
