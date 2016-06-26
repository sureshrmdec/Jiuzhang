package leetcode.com.pickup1.easy;

import leetcode.com.hard.No056_Merge_Intervals;

/**
 * Created by tclresearchamerica on 6/25/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/string-to-integer-atoi/
 * ****************************************************
 * Description:
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself
 * what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to
 * gather all the input requirements up front.
 * ****************************************************
 * Thought:
 * 1.超过整数的最大值,但是该返回什么值呢?
 * 2.char可能为非数字
 * 3.
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
public class No008_String_to_Integer_atoi {

    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        long rst = 1;
        int flag = 1;

        if (str.length() == 0) return 0;
        int i = 0;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            flag = -1;
            i++;
        }

        for (; i < str.length(); i++) {
            if (isValidNumber(str.charAt(i))) {
                rst = rst * 10 + (int) str.charAt(i);
                if (rst > Integer.MAX_VALUE) {
                    return 0;
                }
            } else {
                return 0;
            }

        }
        rst *= flag;
        if (rst < Integer.MIN_VALUE) return 0;
        return (int) rst;
    }

    private boolean isValidNumber(char num) {
        if (Character.isDigit(num)) return true;
        else return false;
    }
}
