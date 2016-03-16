package leetcode.com.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 2016/3/14.
 * Location:
 * https://leetcode.com/problems/pascals-triangle/
 * **************************************************
 * Description:
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * ***************************************************
 * Solution:
 *
 */
public class No118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();

        if (numRows == 0) return rst;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        rst.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                tmp.add(-1);
            }

            List<Integer> prev = rst.get(i - 1);
            tmp.set(0, prev.get(0));
            tmp.set(i, prev.get(i - 1));
            for (int j = 1; j < i; j++) {
                tmp.set(j, prev.get(j - 1) + prev.get(j));
            }
            rst.add(tmp);
        }

        return rst;
    }
}
