package leetcode.com.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 2016/3/5.
 * Location:
 * https://leetcode.com/problems/text-justification/
 * **************************************************
 * Description:
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is
 * fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * <p>
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * ************************************************
 * Solution:
 */
public class No068_Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int wordsCount = words.length;
        List<String> rst = new ArrayList<>();
        int curLen = 0;
        int lastI = 0;
        for (int i = 0; i < wordsCount; i++){
            if (i ==wordsCount || curLen + words[i].length() - lastI > maxWidth){
                StringBuffer buf = new StringBuffer();
                int spaceCount = maxWidth -curLen;
            }
        }

        return rst;
    }
}
