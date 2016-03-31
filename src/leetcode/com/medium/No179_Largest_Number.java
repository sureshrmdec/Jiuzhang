package leetcode.com.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jason on 2016/3/30.
 * Location:
 * https://leetcode.com/problems/largest-number/
 * ************************************************
 * Description:
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer
 * ************************************************
 * Solution:
 * 完全没有想到解法。看了答案后才明白，用Comparator接口来实现啊，但是要处理下
 */
public class No179_Largest_Number {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new NumberComparator());
        StringBuilder sb = new StringBuilder();
        for (String str : strs)
            sb.append(str);
        String result = sb.toString();
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0')
            index++;

        return result.substring(index);
    }

    public class NumberComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
}