package array;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-19.
 */

public class MaxArea {

    /*
    * 盛最多水的容器
    * 双指针解决问题
    * 盛水的多少取决于最外侧的两根棍的长度，因此只需要控制最外侧就可以了
    * */

    public int maxArea(int[] height) {

        int l = 0, r = height.length;
        int max = -1;
        while (l < r) {

            if (height[l] < height[r]) {
                max = Math.max(max, (r - l) * height[l]);
                l++;
            } else {
                max = Math.max(max, (r - l) * height[r]);
                r--;
            }
        }
        return max;

    }

}
