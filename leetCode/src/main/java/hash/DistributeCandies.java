package main.java.hash;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class DistributeCandies {


    public int distributeCandies(int[] candies) {


        boolean remainer[] = new boolean[200001];
        int target = candies.length / 2;
        int kind = 0;

        for (int i : candies) {
            if (!remainer[i+100000]) {
                remainer[i+100000] = true;
                kind++;
            } else
                target--;
        }

        if (target < 0) return kind;
        return kind-target;
    }
}
