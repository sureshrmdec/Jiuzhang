package leetcode.com.pickup1.medium;

/**
 * Created by tclresearchamerica on 7/22/16.
 * *******************************************
 * Location:
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * *******************************************
 * Description:
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A .
 * means it can represent any one letter.
 * <p>
 * For example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * <p>
 * *******************************************
 * Thought:
 * 1.基本思想是HashMap来解决问题,但是问题在于,如何应对.的问题,1个.还好,如果是多个的话,就很难说了啊
 * 2.那么我们现在用什么数据结构比较合适呢?想!
 * 3.根据查找的特定分析,用Tree这个结构是比较合适的,那么用哪种树呢?这个树要满足能够在平行的节点当中移动才可以啊!trie树!
 * *******************************************
 * *******************************************
 * *******************************************
 * *******************************************
 * *******************************************
 * *******************************************
 * *******************************************
 */
public class No211_And_and_Search_Word_Data_structure_design {
}

public class WordDictionary {

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