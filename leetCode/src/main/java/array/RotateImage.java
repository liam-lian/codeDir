package array;
/*
 *   Created by zview@qq.com on 18-4-12.
 */

public class RotateImage {

    public void rotate(int[][] mat) {

        int n = mat.length;
        int t[] = new int[n];

        //首相把矩阵的第i行和第(n-i-1)行交换
        for (int i = 0; i < n / 2; i++) {
            System.arraycopy(mat[i], 0, t, 0, n);
            System.arraycopy(mat[n - i - 1], 0, mat[i], 0, n);
            System.arraycopy(t, 0, mat[n - i - 1], 0, n);
        }

        //做对角线交换
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
    }
}
