package main.java.graph;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {


        Map<Integer,List<Integer>> map=new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            List<Integer> val=map.get(times[i][0]);
            if(val==null){
                val=new ArrayList<Integer>();
                val.add(i);
                map.put(times[i][0],val);
            }else {
                val.add(i);
            }

        }
        


        boolean[] isValid=new boolean[N+1];
        Integer shortedTime[]=new Integer[N+1];
        shortedTime[K]=0;
        isValid[K]=true;
        int curNode=K;
        int count=N;

        int next;
        while (curNode>0){
            count--;
            int min=Integer.MAX_VALUE;
            next=0;

            List<Integer> val=map.get(curNode);
            if(val==null) break;

            for (int i = 1; i < times[i].length; i++) {
                if(times[curNode][i]<1) break;

            }
            isValid[next]=true;
            shortedTime[next]=min;
            curNode=next;
        }

        if (count>0) return -1;
        int max=-1;
        for(int i:shortedTime){
            if(i>max) max=i;
        }
        return max;

    }
}
