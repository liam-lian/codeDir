package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-26.
 */
public class MergeIntervals {

    class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /*
    * 将区间的头进行排序
    * 排序之后可以更加方便的将区间进行合并。
    * 因为所有的合并的区间可能的位置都是当前易经存在的合理的第一个区间
    * */
    public List<Interval> merge(List<Interval> intervals) {

        if (intervals==null || intervals.size()<2){
            return intervals;
        }

        Comparator<Interval> comparator=new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        };
        intervals.sort(comparator);
        List<Interval> res=new ArrayList<>();
        res.add(intervals.get(0));
        for(Interval interval:intervals){
            Interval lastres=res.get(res.size()-1);
            if(interval.start<=lastres.end){
                //可以合并
                lastres.end=Math.max(lastres.end,interval.end);
            }else {
                res.add(interval);
            }
        }
        return res;
    }
}
