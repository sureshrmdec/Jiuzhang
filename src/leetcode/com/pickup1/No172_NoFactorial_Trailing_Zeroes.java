package leetcode.com.pickup1;

/**
 * Created by jason on 2016/7/18.
 * ****************************************************
 * Location
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * ****************************************************
 * Description:
 * Given an integer n, return the number of trailing zeroes in n!.
 * ****************************************************
 * Thoughts:
 * 1.算是结尾有几个零，推算下：
 * 1--4：0
 * 1-5:1
 * 1-9:
 * 1-10：2
 * 1-14:2
 * 1-15:3
 * 1-19:3
 * 1-20:4
 * 25;5*5
 * 推算 num/5等于几就有几个零,要小心有几个5，不断的除，求有多少个5，有的数字有多个5，例如25,125等等
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
public class No172_NoFactorial_Trailing_Zeroes {
    public int trailingZeroes(int n) {
        int sum=0;
        while (n>0){
            sum+=n/5;
            n/=5;
        }
        return sum;
    }
}
