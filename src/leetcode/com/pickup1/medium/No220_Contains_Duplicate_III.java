package leetcode.com.pickup1.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by tclresearchamerica on 7/22/16.
 * *****************************************************************************
 * Location:
 * https://leetcode.com/problems/contains-duplicate-iii/
 * *****************************************************************************
 * Description:
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that
 * the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 * *****************************************************************************
 * Thoughts:
 * 1.数组中的索引差最大为k,数值最大差为t
 * *****************************************************************************
 * Reference:https://segmentfault.com/a/1190000003709386
 * 二叉搜索树
 * 时间 O(NlogK) 空间 O(K)
 * 要求判断之前是否存在差值小于t的数字，我们需要知道在当前数字x两边的数字，即最大的小于x的数字和最小的大于x的数字。
 * 二叉搜索树有也有这样的性质，它的左子树的最右节点是最大的较小值，右子树的最左节点是最小的较大值。这里我们用TreeSet这个类，
 * 它实现了红黑树，并有集合的性质，非常适合这题。我们同样也是维护一个大小为k的TreeSet，多余k个元素时把最早加入的给删除。
 * 用ceiling()和floor()可以找到最小的较大值和最大的较小值。
 * *****************************************************************************
 * Hindsight:
 * 1.bucket的做法比较好
 * *****************************************************************************
 * *****************************************************************************
 * *****************************************************************************
 * *****************************************************************************
 * *****************************************************************************
 * *****************************************************************************
 * *****************************************************************************
 */
public class No220_Contains_Duplicate_III {

    /*
    https://discuss.leetcode.com/topic/15199/ac-o-n-solution-in-java-using-buckets-with-explanation
    As a followup question, it naturally also requires maintaining a window of size k. When t == 0, it reduces to
     the previous question so we just reuse the solution.

Since there is now a constraint on the range of the values of the elements to be considered duplicates,
it reminds us of doing a range check which is implemented in tree data structure and would take O(LogN) if a balanced
tree structure is used, or doing a bucket check which is constant time. We shall just discuss the idea using bucket here.

Bucketing means we map a range of values to the a bucket. For example, if the bucket size is 3, we consider
0, 1, 2 all map to the same bucket. However, if t == 3, (0, 3) is a considered duplicates but does not map to the
 same bucket. This is fine since we are checking the buckets immediately before and after as well. So, as a rule of
 thumb, just make sure the size of the bucket is reasonable such that elements having the same bucket is immediately
 considered duplicates or duplicates must lie within adjacent buckets. So this actually gives us a range of possible
  bucket size, i.e. t and t + 1. We just choose it to be t and a bucket mapping to be num / t.

Another complication is that negative ints are allowed. A simple num / t just shrinks everything towards 0. Therefore,
 we can just reposition every element to start from Integer.MIN_VALUE.
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate_slow(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            //最大的小于x的数字
            if (treeSet.ceiling(x) != null && treeSet.ceiling(x) <= t + x) return true;
            //最小的大于x的数字
            if (treeSet.floor(x) != null && treeSet.floor(x) >= x - t) return true;
            treeSet.add(x);
            if (treeSet.size() > k) treeSet.remove(nums[i - k]);
        }
        return false;
    }
}
