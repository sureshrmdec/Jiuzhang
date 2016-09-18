package leetcode.com.pickup1.hard;

import java.util.*;

/**
 * Created by tclresearchamerica on 9/18/16.
 * Locations：
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * ************************************************************************
 * Descriptions:
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
 * and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * *************************************************************************
 * Solutions:
 * *************************************************************************
 * Ref
 * https://segmentfault.com/a/1190000003903467
 * 哈希表计数法
 * 复杂度
 * 时间 O(NK) 空间 O(M)
 * <p>
 * 思路
 * 由于数组中所有单词的长度都是一样的，我们可以像Longest Substring with At Most Two Distinct Characters中一样，
 * 把每个词当作一个字母来看待，但是要遍历K次，K是单词的长度，因为我们要分别统计从下标0开头，从下标1开头。。。直到下标K-1开头的字符串。
 * 举例来说foobarfoo，给定数组是[foo, bar]，那我们要对foo|bar|foo搜索一次，对oob|arf|oo搜索一次，对oba|rfo|o搜索一次，
 * 我们不用再对bar|foo搜索，因为其已经包含在第一种里面了。每次搜索中，我们通过哈希表维护一个窗口，比如foo|bar|foo中，
 * 我们先拿出foo。如果foo都不在数组中，那说明根本不能拼进去，则哈希表全部清零，从下一个词开始重新匹配。但是foo是在数组中的，
 * 所以给当前搜索的哈希表计数器加上1，如果发现当前搜索中foo出现的次数已经比给定数组中foo出现的次数多了，
 * 我们就要把上一次出现foo之前的所有词都从窗口中去掉，如果没有更多，则看下一个词bar，不过在这之前，我们还要看看窗口中有多少个词了，
 * 如果词的个数等于数组中词的个数，说明我们找到了一个结果。
 * <p>
 * 注意
 * 先判断输入是否为空，为空直接返回空结果
 * *************************************************************************
 * Hindsight:
 * 1.要有滑动窗口的概念,这个窗口的大小就是单个单词的长度,每次游标只移动窗口大小,而不是游标+1,且游标的上限是<=s.length()-len
 * 2.这个解法里面,count,和哈希表的数值,只是不断地增加或减少,通过判断单个单词的出现次数是否超标,和count是否同输入数组大小相等来判断是否有解法
 * 3.start的步长也是滑动窗口的大小
 * 4.单词次数过多,或是找到一个解后,需要从当前的哈希表中剔除,start位置出现的单词,并调整其出现频率
 * 5.一旦发生单词不匹配的情况,count,start,curMap都要复原,start=j+len<即下一个有效位置>
 * *************************************************************************
 * *************************************************************************
 * *************************************************************************
 */
public class No030_Substring_with_Concatenation_of_All_Words {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList();
        //boundary check
        if (s == null || "".equals(s) || words == null || words.length == 0) return result;
        //哈希表统计单词出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
        }
        int len = words[0].length();
        int[] count = new int[1];
        int[] start = new int[1];

        for (int i = 0; i < len; i++) {
            count[0] = 0;
            start[0] = i;
            Map<String, Integer> curMap = new HashMap<>();
            //bug2: j的增长步长是len,而不是1
            for (int j = i; j <= s.length() - len; j+=len) {
                String temp = s.substring(j, j + len);
                //所选单词是否是属于数组中的内容
                if (map.containsKey(temp)) {
                    count[0]++;
                    curMap.put(temp, curMap.containsKey(temp) ? curMap.get(temp) + 1 : 1);

                    while (curMap.get(temp) > map.get(temp)) {
                        helper(curMap, s, len, count, start);
                    }
                    if (count[0] == words.length) {
                        result.add(start[0]);
                        //cleaning data
                        helper(curMap, s, len, count, start);

                    }
                } else {
                    curMap.clear();
                    //?此处+len,是因为,在下一个大循环中,会从start+1的位置开始处理,
                    //此时的处理周期就是len
                    //bug2: start的增长步长是len,而不是1
                    start[0] = j + len;
                    //bug3: 数据清零的话,count也要从零开始计数
                    count[0] =0;
                }

            }

        }
        return result;
    }

    private void helper(Map<String, Integer> curMap, String s, int len, int[] count, int[] start) {
        String leftMost = s.substring(start[0], start[0] + len);
        curMap.put(leftMost, curMap.get(leftMost) - 1);
        count[0]--;
        start[0] += len;
    }

    public List<Integer> findSubstring_ref(String s, String[] words) {
        List<Integer> res = new LinkedList<Integer>();
        if (words == null || words.length == 0 || s == null || s.equals("")) return res;
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        // 统计数组中每个词出现的次数，放入哈希表中待用
        for (String word : words) {
            freq.put(word, freq.containsKey(word) ? freq.get(word) + 1 : 1);
        }
        // 得到每个词的长度
        int len = words[0].length();
        // 错开位来统计
        for (int i = 0; i < len; i++) {
            // 建一个新的哈希表，记录本轮搜索中窗口内单词出现次数
            HashMap<String, Integer> currFreq = new HashMap<String, Integer>();
            // start是窗口的开始，count表明窗口内有多少词
            int start = i, count = 0;
            //bug1: j的增长步长是len,而不是1
            for (int j = i; j <= s.length() - len; j += len) {
                String sub = s.substring(j, j + len);
                // 看下一个词是否是给定数组中的
                if (freq.containsKey(sub)) {
                    // 窗口中单词出现次数加1
                    currFreq.put(sub, currFreq.containsKey(sub) ? currFreq.get(sub) + 1 : 1);
                    count++;
                    // 如果该单词出现次数已经超过给定数组中的次数了，说明多来了一个该单词，所以要把窗口中该单词上次出现的位置及之前所有单词给去掉
                    while (currFreq.get(sub) > freq.get(sub)) {
                        String leftMost = s.substring(start, start + len);
                        currFreq.put(leftMost, currFreq.get(leftMost) - 1);
                        start = start + len;
                        count--;
                    }
                    // 如果窗口内单词数和总单词数一样，则找到结果
                    if (count == words.length) {
                        String leftMost = s.substring(start, start + len);
                        currFreq.put(leftMost, currFreq.get(leftMost) - 1);
                        res.add(start);
                        start = start + len;
                        count--;
                    }
                    // 如果截出来的单词都不在数组中，前功尽弃，重新开始
                } else {
                    currFreq.clear();
                    start = j + len;
                    count = 0;
                }
            }
        }
        return res;
    }

}
