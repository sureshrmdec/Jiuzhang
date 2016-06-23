package leetcode.com.pickup1.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tclresearchamerica on 6/23/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 * ****************************************************
 * Description:
 * Given a string of numbers and operators, return all possible results from computing all the different possible
 * ways to group numbers and operators. The valid operators are +, - and *.
 * Example 1
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * Example 2
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 * ****************************************************
 * Thoughts:
 * 1.Graph? tree? permutation? Combination?
 * 2.看了之前的做法留下的笔记,发现当时也并未理解掌握哦...
 * 3.看了之前的答案,相当于说就是,根据符号拆解string,还是循环拆解,然后再将数据一个一个计算出来
 * 因为用到了hashmap所以没有什么问题
 * ****************************************************
 * Hindsight:
 * 不知道这类问题如何解决,所以一直无法破解
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No241_Different_Ways_to_Add_Parentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        return result;
    }

    HashMap<String, List<Integer>> hashMap = new HashMap<>();

    public List<Integer> diffWaysToCompute_copy(String input) {
        List<Integer> result = new ArrayList<>();

        if (hashMap.containsKey(input)) return hashMap.get(input);

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int v1 : left) {
                    for (int v2 : right) {
                        if (c == '+') result.add(v1 + v2);
                        if (c == '-') result.add(v1 - v2);
                        if (c == '*') result.add(v1 * v2);
                    }
                }
            }
        }

        if (result.isEmpty()) result.add(Integer.parseInt(input));
        hashMap.put(input, result);

        return result;

    }
}
