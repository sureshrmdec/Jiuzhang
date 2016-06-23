package leetcode.com.pickup1.easy;

/**
 * Created by tclresearchamerica on 6/23/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/valid-parentheses/
 * ****************************************************
 * Description:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine
 * if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * ****************************************************
 * Thoughts:
 * 1.需要避免的case是先有右括号,再有左括号,以及所有的右括号没有被干掉的情况,但是提示的结果case更简单些,比价好判断.
 * 2.不知道为什么会出现我的运行结果和 leetcode的运行结果不一致的问题
 * ****************************************************
 * Time: 15 mins
 * Beats:
 * Bug:
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No020_Valid_Parentheses {
    public static void main(String[] args) {
        No020_Valid_Parentheses obj = new No020_Valid_Parentheses();
        obj.isValid("()");
    }

    public boolean isValid(String s) {
        int index = 0;

        while ((index + 2) <= s.length()) {
            if (s.substring(index, index + 2) == "()" ||
                    s.substring(index, index + 2) == "[]" ||
                    s.substring(index, index + 2) == "{}") {
                index += 2;
            } else {
                return false;
            }
        }

        if (index != s.length()) return false;

        return true;
    }
}
