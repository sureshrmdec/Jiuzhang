package leetcode.com.easy;

import java.util.Arrays;

/**
 * Created by tclresearchamerica on 4/9/16.
 * Location:
 * https://leetcode.com/problems/contains-duplicate-ii/
 * ****************************************************
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class No219_Contains_Duplicate_II {

    public static void main(String[] args) {
        No219_Contains_Duplicate_II obj = new No219_Contains_Duplicate_II();
        obj.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null) return false;
        int[] numBK = nums.clone();
        Arrays.sort(numBK);
        for (int i = 1; i < numBK.length; i++) {
            int j = 0;
            while (i < numBK.length && numBK[i] == numBK[i - 1]) {
                for (; j < nums.length; j++) {
                    if (nums[j] == numBK[i]) {
                        //bug1:没有对kk+j进行范围控制
                        for (int kk = 1; kk <= k && j + kk < nums.length; kk++) {
                            //bug2:kk->j+kk
                            if (nums[j + kk] == nums[j]) {
                                return true;
                            }
                        }
                    }
                }
                i++;
            }
        }

        return false;
    }
}
