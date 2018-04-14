package array;

import java.util.Arrays;

public class ArrayPartioni {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }

    /*
    *   由于所有可能的取值的范围都已经给你了-10000-10000.因此应该使用计数排序速度更快
    * */
    public int arrayPairSum1(int[] nums) {
        int count[]=new int[20001];
        for(int i:nums){
            count[i]++;
        }
        boolean odd=true;

        int countIndex=0,midCoumt=0,res=0;

        while (midCoumt<nums.length/2){
            if(count[countIndex]>0){
                count[countIndex]--;
                if(odd) {
                    midCoumt++;
                    res+=countIndex;
                }
                odd=!odd;
            }
        }
        return res;
    }

}
