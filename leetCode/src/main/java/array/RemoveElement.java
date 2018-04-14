package array;

/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int l, r = nums.length - 1, res = nums.length;
        for (; r >= 0; r--) {
            if (nums[r] != val) break;
            res--;
        }
        for (l = 0; l < r; l++) {
            if (nums[l] == val) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;

                for (; r > l; r--) {
                    if (nums[r] != val) break;
                    res--;
                }
                if (r == l) return res;
            }
        }
        return res;
    }
}