package leetcode.com.medium;

/**
 * Created by jason on 2016/7/24.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/wiggle-subsequence/
 * ****************************************************
 * Description:
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate
 * between positive and negative. The first difference (if one exists) may be either positive or negative.
 * A sequence with fewer than two elements is trivially a wiggle sequence.
 * <p>
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and
 * negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two
 * differences are positive and the second because its last difference is zero.
 * <p>
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence
 * is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving
 * the remaining elements in their original order.
 * <p>
 * Examples:
 * <p>
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 * <p>
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * <p>
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * <p>
 * Follow up:
 * Can you do it in O(n) time?
 * ****************************************************
 * Thoughts:
 * 1.摇摆数组，计算最长的+-+-+-，或是-+-+的长度+1
 * 2.要求O(n)的时间复杂度，
 * 3.類似於那個計算最大求和值的問題，有一個最大的max保留下來，還有一個當前的長度保留下來，
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No376_Wiggle_Subsequence {

    public static void main(String[] args) {
        No376_Wiggle_Subsequence obj = new No376_Wiggle_Subsequence();
        obj.wiggleMaxLength(new int[]{0,0});
    }
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;

        //bug1:当有2个元素相等的时候，会出现问题
        int local = 0, max = 0;
        boolean preSign = (nums[1] - nums[0]) > 0;
        boolean equalSign = nums[1] == nums[0];
        local = equalSign ? 0 : 1;
        boolean curSign = false;
        for (int i = 2; i < nums.length; i++) {
            equalSign = nums[i] == nums[i - 1];
            if (equalSign) {
                max = Math.max(max, local);
                local = 0;
            } else {
                curSign = (nums[i] - nums[i - 1]) > 0;
                if (curSign ^ preSign) {
                    local++;
                } else {
                    max = Math.max(local, max);
                    local = 1;
                }
                preSign=curSign;
            }
//        for (int i =2;i<nums.length;i++){
//            curSign=(nums[i]-nums[i-1])>0;
//            if (curSign^preSign){
//                local++;
//            }else {
//                max= Math.max(local,max);
//                local=1;
//            }
        }

        return Math.max(local, max) + 1;
    }
}
