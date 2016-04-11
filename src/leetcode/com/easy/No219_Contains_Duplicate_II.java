package leetcode.com.easy;

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
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null) return false;
        for (int i = 0; i < nums.length; i++) {
            int j = 1;
            //bug1: should be i <=k
            //bug2: should be (i+j) < nums.length
            for (; j <= k && (i + j) < nums.length; j++)
                //bug3: should be nums[i+j]
                if (nums[i] == nums[i + j]) return true;
        }

        return false;
    }
}
