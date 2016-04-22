package leetcode.com.medium;

/**
 * Created by tclresearchamerica on 4/18/16.
 * Location:
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * **********************************************************
 * Description:
 * Implement a trie with insert, search, and startsWith methods.
 * 又称单词查找树，Trie树，是一种树形结构，是一种哈希树的变种。典型应用是用于统计，排序和保存大量的字符串（但不仅限于字符串），
 * 所以经常被搜索引擎系统用于文本词频统计。
 * 它的优点是：利用字符串的公共前缀来减少查询时间，最大限度地减少无谓的字符串比较，查询效率比哈希树高。
 * 它有3个基本性质：
 * 根节点不包含字符，除根节点外每一个节点都只包含一个字符； 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串；
 * 每个节点的所有子节点包含的字符都不相同。
 * ***********************************
 * 基本操作编辑
 * 其基本操作有：查找、插入和删除,当然删除操作比较少见。
 * ***********************************
 * 实现方法编辑
 * 搜索字典项目的方法为：
 * (1) 从根结点开始一次搜索；
 * (2) 取得要查找关键词的第一个字母，并根据该字母选择对应的子树并转到该子树继续进行检索；
 * (3) 在相应的子树上，取得要查找关键词的第二个字母,并进一步选择对应的子树进行检索。
 * (4) 迭代过程……
 * (5) 在某个结点处，关键词的所有字母已被取出，则读取附在该结点上的信息，即完成查找。
 * 其他操作类似处理
 * **********************************************************
 */
public class No208_implement_Trie_Prefix_Tree {
    public static void main(String[] args) {

    }


    private TrieNode root;

    public No208_implement_Trie_Prefix_Tree() {
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.arr[index] == null) {
                TrieNode tmp = new TrieNode();
                node.arr[index] = tmp;
                node = tmp;
            } else {
                node = node.arr[index];
            }
        }
        node.isEnd = true;
    }

    public TrieNode searchNode(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (p.arr[index] != null) {
                p = p.arr[index];
            } else {
                return null;
            }
        }

        if (p == root)
            return null;

        return p;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if (p != null && p.isEnd) {
            return true;
        } else {
            return false;
        }

    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if (p == null) {
            return false;
        } else {
            return true;
        }
    }
// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
}

class TrieNode {
    TrieNode[] arr;
    boolean isEnd;

    TrieNode() {
        //26个字母都准备好空间
        arr = new TrieNode[26];
    }
}
