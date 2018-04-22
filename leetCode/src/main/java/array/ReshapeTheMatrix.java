package array;


/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        if(nums==null || nums.length==0) return nums;

        int row=nums.length;
        int column=nums[0].length;
        if(row*column!=r*c) return nums;

        int[][]res=new int[r][c];

        int index=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                res[index/r][index%r]=nums[i][j];
                index++;
            }
        }

        return res;

    }
}
