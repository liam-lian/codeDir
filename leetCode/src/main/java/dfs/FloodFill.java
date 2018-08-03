package dfs;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-26.
 */
public class FloodFill {
    private class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {


        int val = image[sr][sc];
        if (val == newColor) return image;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(sr, sc));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.x > 0 && image[cur.x - 1][cur.y] == val) {
                queue.add(new Pair(cur.x - 1, cur.y));
            }
            if (cur.x < image.length - 1 && image[cur.x + 1][cur.y] == val) {
                queue.add(new Pair(cur.x + 1, cur.y));
            }

            if (cur.y > 0 && image[cur.x][cur.y - 1] == val) {
                queue.add(new Pair(cur.x, cur.y - 1));
            }

            if (cur.y < image[0].length - 1 && image[cur.x][cur.y + 1] == val) {
                queue.add(new Pair(cur.x, cur.y + 1));
            }
            image[cur.x][cur.y] = newColor;
        }
        return image;
    }
}
