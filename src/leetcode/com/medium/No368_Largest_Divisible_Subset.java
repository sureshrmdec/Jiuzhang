package leetcode.com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tclresearchamerica on 7/29/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/largest-divisible-subset/
 * ****************************************************
 * Description:
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements
 * in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * <p>
 * nums: [1,2,3]
 * <p>
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * <p>
 * nums: [1,2,4,8]
 * <p>
 * Result: [1,2,4,8]
 * ****************************************************
 * Thought:
 * 1.https://segmentfault.com/a/1190000005922634
 * 复杂度
 * O(N^2) 时间 O(N) 空间
 * <p>
 * 思路
 * 和LIS很相似，dp[i]表示nums数组从0到i的最大集合的size.
 * 这题应该分成两个问题：
 * <p>
 * 得到最大集合size
 * 输出这个集合
 * 对于第一个问题，最大集合size就是dp数组的最大值，可以边画表边维护一个当前最大值;
 * 对于第二个问题，我们要维护一个parent数组，记录nums[i]加入到了哪个集合;
 * dp[i] = max(dp[i], dp[j] + 1), where 0<=j<i
 * <p>
 * 注意这个case：
 * [1,2,4,8,9,72]
 * 到72的时候，往前找到9，可以整除，更新dp[5]为max(1, 2 + 1) = 3,
 * 注意此时应该继续往前找，不能停，直到找到8,发现dp[3] + 1 = 5 > 3，于是更新dp[i]
 * 注意就是不能停，找到一个能整除并不够，前面有可能有更大的啊~~
 * <p>
 * <p>
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No368_Largest_Divisible_Subset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<Integer>();
        //nums has at least one element
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);//当parent数组中某数为-1时，表示这个数自己是一个集合
        int max = 1, max_index = -1;
        for (int i = 1; i < n; i++) {   //calculate dp[i]
            for (int j = i - 1; j >= 0; j--) {  //i > j
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {    //positive distinct numbers in num
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    if (dp[i] > max) {
                        max = dp[i];
                        max_index = i;
                    }
                }
            }
        }
        return genResult(nums, parent, max_index);
    }

    public List<Integer> genResult(int[] nums, int[] parent, int max_index) {
        List<Integer> result = new ArrayList<>();
        if (max_index == -1) {  //每个数都是单独成集合，都不能合并
            result.add(nums[0]);    //随便输出一个数，这里选第一个
            return result;
        }
        int iter = max_index;
        while (iter != -1) {
            result.add(nums[iter]);
            iter = parent[iter];
        }
        return result;
    }
}
