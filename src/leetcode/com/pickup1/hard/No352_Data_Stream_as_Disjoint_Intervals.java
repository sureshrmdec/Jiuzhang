package leetcode.com.pickup1.hard;

import leetcode.com.util.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by tclresearchamerica on 8/10/16.
 * **************************************************************
 * Location:
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 * **************************************************************
 * Description:
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers
 * seen so far as a list of disjoint intervals.
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * <p>
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * **************************************************************
 * Ref:
 * https://discuss.leetcode.com/topic/46887/java-solution-using-treemap-real-o-logn-per-adding
 * **************************************************************
 * **************************************************************
 * **************************************************************
 * **************************************************************
 * **************************************************************
 * **************************************************************
 * **************************************************************
 * **************************************************************
 * **************************************************************
 */
public class No352_Data_Stream_as_Disjoint_Intervals {
}

class SummaryRanges {
    TreeMap<Integer, Interval> tree;

    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val)) return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if(l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } else if(l != null && tree.get(l).end + 1 >= val) {
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } else if(h != null && h == val + 1) {
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } else {
            tree.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
}