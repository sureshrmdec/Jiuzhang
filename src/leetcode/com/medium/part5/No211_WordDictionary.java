package leetcode.com.medium.part5;

/**
 * Created by tclresearchamerica on 4/20/16.
 * *****************************************************************************
 * Location:
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * *****************************************************************************
 * Description:
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * *****************************************************************************
 * Solution:
 */
public class No211_WordDictionary {
    // Adds a word into the data structure.
    public void addWord(String word) {

    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");