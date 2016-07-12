package leetcode.com.pickup1.hard;

/**
 * Created by tclresearchamerica on 7/11/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * ****************************************************
 * Description:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * ****************************************************
 * Thoughts:
 * 1.看到买卖股票就歇了,这次是k次买卖,是那个只准买卖2次的加强版
 * ****************************************************
 * Ref:https://discuss.leetcode.com/topic/8984/a-concise-dp-solution-in-java/4
 * DP: t(i,j) is the max profit for up to i transactions by time j (0<=i<=K, 0<=j<=T).
 * t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax) gives us the maximum price when we sell at this price;
 * tmpMax = Math.max(tmpMax, t[i - 1][j] - prices[j]) gives us the value when we buy at this price and leave this
 * value for prices[j+1].
 * ****************************************************
 * Time: 50mins
 * Beat: 10%
 * Bug: -
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No188_Best_Time_to_Buy_and_Sell_Stock_IV {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
