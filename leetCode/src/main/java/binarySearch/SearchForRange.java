package binarySearch;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class SearchForRange {


    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int low = 0, high = nums.length - 1;

        while (low + 1 < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) {
                high = mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int lRange ;
        if (nums[low] == target) {
            lRange = low;
        } else if (nums[high] == target) {
            lRange = high;
        } else {
            return new int[]{-1, -1};
        }
        low = lRange;
        high = nums.length - 1;
        while (low + 1 < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) {
                low = mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int rRange = 0;
        if (nums[high] == target) {
            rRange = high;
        } else if (nums[low] == target) {
            rRange = low;
        }
        return new int[]{lRange, rRange};
    }
}
