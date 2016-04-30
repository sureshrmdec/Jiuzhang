package leetcode.com.hard;

/**
 * Created by tclresearchamerica on 4/26/16.
 * Location:
 * https://leetcode.com/problems/basic-calculator/
 * ************************************************
 * Description:
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * ************************************************
 */
public class No224_Basic_Calculator {
    public int calculate(String s) {
        if (s==null)    return 0;
        String temp= s.replaceAll(" ","");
        if (temp.length()==0)   return 0;
        return 1;
    }
}
