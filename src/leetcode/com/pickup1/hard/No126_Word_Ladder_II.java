package leetcode.com.pickup1.hard;

import java.util.*;

/**
 * Created by tclresearchamerica on 8/3/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/word-ladder-ii/
 * ****************************************************
 * Description:
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation
 * sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * <p>
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * ****************************************************
 * Thoughts:
 * 1.recursive,不断替换,再循环,再替换的过程-->时间复杂度太高了,因为每个字母都替换一遍的话,相当于遍历了图的全部路径,
 * 会导致时间超时-->错误思想源于没有画图实现
 * 2.根据来自https://segmentfault.com/a/1190000002567124的解释,还是先要构筑一个根据BFS的达成的树
 * <p>
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No126_Word_Ladder_II {


    boolean isConnected = false;

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        //we use bi-dirctional BFS to find shortest path
        Set<String> fwd = new HashSet<>();
        fwd.add(beginWord);

        Set<String> bwd = new HashSet<>();
        bwd.add(endWord);

        Map<String, List<String>> hs = new HashMap<>();
        createBFS(fwd, bwd, wordList, false, hs);

        List<List<String>> result = new ArrayList<>();

        //if two parts can not be connected, then return empty list
        if (!isConnected) return result;

        //we need to add start node to temp list as there is no other node can get start node
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);

        DFS(result, temp, beginWord, endWord, hs);

        return result;
    }


    //prepare for the graph
    public void createBFS(Set<String> forward, Set<String> backward, Set<String> dict, boolean swap, Map<String, List<String>> hs) {

        //boundary check
        if (forward.isEmpty() || backward.isEmpty()) return;

        //we always do BFS on direction with less nodes
        //here we assume forward set has less nodes, if not, we swap them
        //这个方法好，动态调整后优化处理效果
        if (forward.size() > backward.size()) {
            createBFS(backward, forward, dict, !swap, hs);
            return;
        }

        //remove all forward/backward from dict to avoid duplicate addition
        //new technology:hashmap 可以删除指定的set的数据集
        //bug1:要删除所有的元素，并不是一个：remove-->removeAll
        dict.removeAll(forward);
        dict.removeAll(backward);

        //new set contains all new nodes from forward set
        Set<String> newSet = new HashSet<>();

        //do BFS on every node of forward direction
        for (String str : forward) {
            //try to change each char of str
            for (int i = 0; i < str.length(); i++) {
                //try to replace current char with every chars from a to z
                char[] array = str.toCharArray();

                for (char j = 'a'; j <= 'z'; j++) {
                    array[i] = j;
                    String temp = new String(array);
                    //we skip this string if it is not in dict nor in backward
                    //bug1:因为forward已经被处理过了,而只有dict和backwards需要比较
                    if (!backward.contains(temp) && !dict.contains(temp)) {
                        continue;
                    }

                    //we follow the forward direction
                    //因为forward&backward可能会调换位置,所以key-value会需要变更,但无论如何,
                    String key = !swap ? str : temp;
                    String value = !swap ? temp : str;

                    if (!hs.containsKey(key)) {
                        hs.put(key, new ArrayList<>());
                    }
                    hs.get(key).add(value);
                    //if temp string in backward set, then it will connect two parts
                    if (backward.contains(temp)) {
                        isConnected = true;
                    }

                    //if temp is in dict, then we can add it to newSet as new nodes in next layer
                    if (!isConnected && dict.contains(temp)) {
                        //!!!!此处是newSet,因为str来自于旧的forward集合,所以构造出来的temp肯定要放在newSet中再次循环使用
                        newSet.add(temp);
                    }
                }

            }

        }
        //to force our path to be shortest, we will not do BFS if we have found shortest paht(isConnected=true)
        if (!isConnected) {
            createBFS(newSet, backward, dict, swap, hs);
        }
    }


    //标准的DFS 递归调用了
    private void DFS(List<List<String>> result, List<String> solution, String start, String end, Map<String, List<String>> hs) {
        //we will use DFS, more specifically backtracking to build paths.
        //有可能是LeetCode的测试case 从前疏后密集
        //boundary case
        if (start.equals(end)) {
            result.add(new ArrayList<>(solution));
            return;
        }

        // not each node in hs is valid node in shortest path, if we found current node does not have children node
        //then it mean it's not in shortest path
        if (!hs.containsKey(start)) {
            return;
        }

        for (String s : hs.get(start)) {
            solution.add(s);
            //bug2:此处需要使用新的start了
            DFS(result, solution, s, end, hs);
            solution.remove(solution.size() - 1);
        }

    }

//    private void helper(String beginWord, String endWord, Set<String> wordList, char[] letters,
//                        List<String> solution,
//                        List<List<StringBT>> result) {
//        if (solution.get(solution.size() - 1) == endWord) {
//            result.add(new ArrayList(solution));
//            return;
//        }
//
//        for (int i = 0; i < letters.length; i++) {
//            if (wordList.contains())
//        }
//
//    }
}
