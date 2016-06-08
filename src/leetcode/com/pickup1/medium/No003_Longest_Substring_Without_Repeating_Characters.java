package leetcode.com.pickup1.medium;

/**
 * Created by tclresearchamerica on 6/7/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * ****************************************************
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must
 * be a substring, "pwke" is a subsequence and not a substring.
 * ****************************************************
 * Thought:
 * 1.
 * ****************************************************
 * 这道题的解法没有反应到IntelIngentJ中,所以是copy网络答案搞的解法
 * Time: 30 mins
 * Beats: 90%
 * Bug:-
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No003_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int[] hm = new int[128];
        int i = 0, j = 0, index = 0, max = 0;
        while (j < s.length()) {
            if (hm[s.charAt(j)] == 0) {
                hm[s.charAt(j)] = j + 1;
                j++;
                if (j - i > max) max = j - i;
            } else {
                index = hm[s.charAt(j)];
                if (i < index)
                    i = index;
                hm[s.charAt(j)] = 0;
            }
        }
        return max;
    }
}
