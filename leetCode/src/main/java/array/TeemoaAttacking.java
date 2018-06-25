package array;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-23.
 */

public class TeemoaAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if(timeSeries==null || timeSeries.length==0) return 0;
        int totalDuration=0;
        for (int i = 0; i < timeSeries.length-1; i++) {
            totalDuration+=Math.min(duration,timeSeries[i+1]-timeSeries[i]);
        }
        return totalDuration+duration;
    }
}
