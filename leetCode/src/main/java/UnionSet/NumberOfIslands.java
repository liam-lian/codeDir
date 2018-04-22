package UnionSet;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class NumberOfIslands {


    private int father[];

    private int findRootFather(int childID) {
        while (father[childID] != childID) {
            childID = father[childID];
        }
        return childID;
    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, column = grid[0].length;
        int res = 0;
        father = new int[row * column];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') continue;
                int state = 0;
                int index = i * column + j;
                int rootUp = 0, rootLeft = 0;
                if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                    rootUp = findRootFather(column * (i - 1) + j);
                    state += 1;
                }
                if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                    rootLeft = findRootFather(column * i + j - 1);
                    state += 2;
                }
                if (state == 0) {
                    res++;
                    father[index] = index;
                } else if (state == 3) {
                    if (rootLeft != rootUp) {
                        father[rootLeft] = father[rootUp];
                        res--;
                    }
                    father[index] = father[rootUp];
                } else if (state == 1) {
                    father[index] = father[rootUp];
                } else {
                    father[index] = father[rootLeft];
                }
            }
        }
        return res;
    }
}