package leetcode.com.pickup1.easy;

/**
 * Created by tclresearchamerica on 7/5/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/happy-number/
 * ****************************************************
 * Description:
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number
 * by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in
 * 1 are happy numbers.
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * ****************************************************
 * Thought:
 * 感觉Leetcode的oj有问题
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No202_Happy_Number {

    public static void main(String[] args) {
        No202_Happy_Number obj = new No202_Happy_Number();
        obj.isHappy(1111111);
    }

    public boolean isHappy(int n) {

        int sum = 0;
        while (sum > 9 || sum == 0) {
            sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;

        }

        return sum == 1;

    }
}
