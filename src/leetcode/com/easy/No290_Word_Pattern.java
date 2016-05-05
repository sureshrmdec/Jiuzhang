package leetcode.com.easy;

/**
 * Created by tclresearchamerica on 5/4/16.
 * *******************************************
 * Location:
 * https://leetcode.com/problems/word-pattern/
 * *******************************************
 * Description:
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * *******************************************
 * <p>
 * *******************************************
 */
public class No290_Word_Pattern {

    public boolean wordPattern(String pattern, String str) {
        String[] objArray = str.split(" ");
        int i = 0;
        for (i = 0; i < objArray.length && i < pattern.length(); i++) {
            if (pattern.charAt(i) != objArray[i].charAt(0))
                return false;
        }
        return i == objArray.length && i == pattern.length();

    }
}
