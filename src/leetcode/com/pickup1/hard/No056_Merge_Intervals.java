package leetcode.com.pickup1.hard;

import leetcode.com.util.Interval;
import leetcode.com.util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tclresearchamerica on 7/7/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/merge-intervals/
 * ****************************************************
 * Description:
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No056_Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals) {

        //sort the elements of the  list
        Collections.sort(intervals, new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return o1.start - o2.start;
                    }
                }
        );

        List<Interval> result = new ArrayList<>();
        for (int i=0;i<intervals.size();i++) {
            if ()
        }


        return null;
    }
}
