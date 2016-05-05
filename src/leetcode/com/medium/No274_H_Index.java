package leetcode.com.medium;

import java.util.Arrays;

/**
 * Created by tclresearchamerica on 5/2/16.
 * ******************************************
 * Location:
 * https://leetcode.com/problems/h-index/
 * ******************************************
 * Description:
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute
 * the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have
 * at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them
 * had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each
 * and the remaining two with no more than 3 citations each, his h-index is 3.
 * ******************************************
 * Analysis:
 * 1.排序呗,然后就不懂了,下面是网络的解释
 * 1、将某作者的所有文章的引用频次按照从大到小的位置排列
 * <p>
 * 2、从前到后，找到最后一个满足条件的位置，其条件为：
 * <p>
 * 此位置是数组的第x个，其值为y，必须满足 y >= x;
 * <p>
 * <p>
 * ******************************************
 */
public class No274_H_Index {
    public int hIndex(int[] citations) {
        int h = 0;
        if (citations == null) return h;

        Arrays.sort(citations);

        for (int i = citations.length - 1; i >= 0 && citations[i] >= citations.length - i; i--) {
            h = citations.length - i;
        }

        return h;

    }
}
