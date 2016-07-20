package leetcode.com.medium;

/**
 * Created by tclresearchamerica on 7/10/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * ****************************************************
 * Description:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one
 * and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 * ****************************************************
 * Thoughts:
 * 1.买卖股票的变种,就是有一天是不可用的,当你卖了股票后,所以应该是在原来股票题的基础上加工下即可
 * 2.解法是DP吗?还是啥呢?好困啊
 * 3.让我来定义下,最大获利即当前元素的之前元素的最大-最小 然后累计
 * ****************************************************
 * Reference:   -->还是要继续理解这个说明方法
 * https://discuss.leetcode.com/topic/30431/easiest-java-solution-with-explanations
 * Much simpler explanations:
 * https://discuss.leetcode.com/topic/30680/share-my-dp-solution-by-state-machine-thinking/5
 * ****************************************************
 * Time: 30 mins
 * Beat: 50%
 * Bug:-
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }
}
