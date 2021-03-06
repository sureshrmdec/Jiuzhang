package leetcode.com.hard;

/**
 * Created by tclresearchamerica on 6/14/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/create-maximum-number/
 * ****************************************************
 * Description:
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of
 * length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved.
 * Return an array of the k digits. You should try to optimize your time and space complexity.
 * <p>
 * Example 1:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * return [9, 8, 6, 5, 3]
 * <p>
 * Example 2:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * return [6, 7, 6, 0, 4]
 * <p>
 * Example 3:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * return [9, 8, 9]
 * <p>
 * Credits:
 * ****************************************************
 * Thoughts:
 * 相对位置的不变,对于长度为K的目标数字,它的组成来自于,难道是动态规划吗?
 * 去掉k-1个数字后,找到最大的数字
 * 它是个数列,
 * ****************************************************
 * Reference:
 * https://leetcode.com/discuss/75655/strictly-o-nk-c-solution-with-detailed-explanation
 * https://leetcode.com/discuss/78156/java-17-ms-o-n-m-k-2-or-3-worst-case-merge-with-lazy-computation
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No321_Create_Maximum_Number {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int startIndex1 = 0;
        int startIndex2 = 0;

        int[] maxNumber = new int[k];

        for (int i = 0; i < k; i++) {
            if (len1 + len2 == k) {
                int endIndex1=len1-1;
                int endIndex2=len2-1;
                int index1 = find(nums1, startIndex1, endIndex1);
                int index2 = find(nums2, startIndex2, endIndex2);
                if (index1 >= 0 && index2 >= 0) {
                    if (nums1[index1] > nums2[index2]) {
                        maxNumber[i] = nums1[index1];
                        startIndex1++;

                    } else {
                        maxNumber[i] = nums2[index2];
                        startIndex2++;
                    }
                } else if (index1 >= 0) {
                    maxNumber[i] = nums1[index1];
                    startIndex1++;
                } else if (index2 >= 0) {
                    maxNumber[i] = nums2[index2];
                    startIndex2++;
                }
            } else {
//                int endIndex1=
                int index1 = find(nums1, startIndex1, startIndex1);
                int index2 = find(nums2, startIndex2, startIndex2);

            }

        }
        return null;
    }

    private int find(int[] num, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (num[i] > max) {
                max = num[i];
                index = i;
            }
        }
        return index;
    }
}
