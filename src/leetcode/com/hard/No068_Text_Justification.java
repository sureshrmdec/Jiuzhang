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
    public static void main(String[] args) {
        No068_Text_Justification No068 = new No068_Text_Justification();
        No068.fullJustify(new String[] {
            "This", "is", "an", "example", "of", "text", "justification."
        },16);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int wordsCount = words.length;
        List<String> rst = new ArrayList<>();
        int curLen = 0;
        int lastI = 0;
        for (int i = 0; i < wordsCount; i++) {
            if (i == wordsCount || curLen + words[i].length() - lastI > maxWidth) {
                StringBuffer buf = new StringBuffer();
                int spaceCount = maxWidth - curLen;
                int spaceSlots = i - lastI - 1;
                if (spaceSlots == 0 || i == wordsCount) {
                    for (int j = lastI; j < i; j++) {
                        buf.append(words[j]);
                        if (j != i - 1)
                            appendSpace(buf, 1);
                    }
                    appendSpace(buf, maxWidth - buf.length());
                } else {
                    int spaceEach = spaceCount / spaceSlots;
                    int spaceExtra = spaceCount % spaceSlots;
                    for (int j = lastI; j < i; j++) {
                        buf.append(words[j]);
                        if (j != i - 1) {
                            appendSpace(buf, spaceEach + (j - lastI < spaceExtra ? 1 : 0));
                        }
                    }
                }
                rst.add(buf.toString());
                lastI = i;
                curLen = 0;
            }
            if (i < wordsCount)
                curLen += words[i].length();
        }

        return rst;
    }

    private void appendSpace(StringBuffer sb, int count) {
        for (int i = 0; i < count; i++)
            sb.append(' ');
    }
}
