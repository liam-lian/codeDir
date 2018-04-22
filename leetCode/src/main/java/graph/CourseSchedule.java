package graph;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> after=new ArrayList<>();
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        int InIndex[]=new int[numCourses];
        int finished=0;

        for (int i = 0; i < numCourses; i++) {
            after.add(new ArrayList<>());
        }

        for(int[] prerequisity:prerequisites){

            after.get(prerequisity[1]).add(prerequisity[0]);
            InIndex[prerequisity[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if(InIndex[i]==0){
                queue.offerLast(i);
                finished++;
            }
        }

        while (!queue.isEmpty() ){
            Integer cur=queue.pollFirst();
            for(Integer af:after.get(cur)){
                if(--InIndex[af]==0){
                    queue.add(af);
                    finished++;
                }
            }
        }

        return finished==numCourses;
    }
}
