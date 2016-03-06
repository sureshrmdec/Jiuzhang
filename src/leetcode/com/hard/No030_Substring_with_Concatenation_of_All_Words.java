package leetcode.com.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jason on 2016/2/2.
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
 */
public class No030_Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> toFind = new HashMap<>();
        Map<String, Integer> found = new HashMap<>();
        int m = words.length, n = words[0].length();

        for (int i = 0; i < m; i++) {
            if (!toFind.containsKey(words[i])) {
                toFind.put(words[i], 1);
            } else {
                toFind.put(words[i], toFind.get(words[i]) + 1);
            }
        }

        for (int i = 0; i <= s.length() - n * m; i++) {
            found.clear();
            int j;
            for (j = 0; j < m; j++) {
                int k = i + j * n;
                String stub = s.substring(k, k + n);
                if (!toFind.containsKey(stub)) break;
                if (!found.containsKey(stub)) {
                    found.put(stub, 1);
                } else {
                    found.put(stub, found.get(stub) + 1);
                }
                if (found.get(stub) > toFind.get(stub)) break;
            }
            if (j == m) result.add(i);
        }
        return result;

    }
}
