package main.java.dfs;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import java.util.ArrayList;
import java.util.List;

public class NQueen {


    private StringBuilder emptyQueue;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        emptyQueue = new StringBuilder();
        for (int i = 0; i < n; i++) {
            emptyQueue.append('.');
        }
        int queen[] = new int[n];
        dfs(queen, 0, n);
        return res;
    }

    private void dfs(int[] queue, int k, int n) {

        if (k == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                emptyQueue.setCharAt(queue[i], 'Q');
                list.add(emptyQueue.toString());
                emptyQueue.setCharAt(queue[i], '.');
            }
            res.add(list);
        }
        for (int i = 0; i < n; i++) {
            if (valid(queue, k, i)) {
                queue[k] = i;
                dfs(queue, k++, n);
            }
        }
    }

    private boolean valid(int[] queen, int k, int i) {
        for (int j = 0; j < k; j++) {
            if (queen[j] == i || queen[j] - i == k - j || queen[j] - i == j - k)
                return false;
        }
        return true;
    }
}
