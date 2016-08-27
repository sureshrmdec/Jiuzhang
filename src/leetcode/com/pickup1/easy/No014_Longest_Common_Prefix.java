package leetcode.com.pickup1.easy;

/**
 * Created by tclresearchamerica on 8/26/16.
 * ***************************************************************
 * Location:
 * https://leetcode.com/problems/longest-common-prefix/
 * ***************************************************************
 * Description:
 * Write a function to find the longest common prefix string amongst an array of strings.
 * ***************************************************************
 * Thoughts:
 * 寻找公共前缀,是否可以想象矩阵求column.看了第一版的答案,发现也不难。就是用第一个串当做prefix去搞
 * ***************************************************************
 * Time:10min
 * Beat:25%
 * Bug:-
 * ***************************************************************
 * Hindsight:
 * 开始没有解决问题,原因还是在于没头绪。
 * ***************************************************************
 * ***************************************************************
 * ***************************************************************
 * ***************************************************************
 * ***************************************************************
 * ***************************************************************
 * ***************************************************************
 */
public class No014_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            String target = strs[i];
            while (j < target.length() && j < prefix.length() && target.charAt(j) == prefix.charAt(j)) {
                j++;
            }

            prefix = prefix.substring(0, j);
        }

        return prefix;
    }
}
