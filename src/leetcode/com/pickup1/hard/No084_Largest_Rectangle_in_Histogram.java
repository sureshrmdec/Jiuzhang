package leetcode.com.pickup1.hard;

import leetcode.com.util.ListNode;

/**
 * Created by tclresearchamerica on 7/9/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * ****************************************************
 * Description:
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 * ****************************************************
 * Thoughts:
 * 0.最大的长方形,除了高还要考虑有效长度
 * 1.怎么破?动态规划?这个就要先考虑好解法,再选择合适的数据结构啦!
 * 2.根据提示的这个例子可以知道,在没有循环完毕所有height之前,你是不知道哪个才是我们想要的答案!
 * 3.没有解法,倒推!用栈吗?动态规划?
 * 4.看了答案,发现解法本质都是类似的,就是入栈出栈,关键是规则是不一样的,就是一旦遇到height小的cell,之前的就得出栈计算面积,
 * 这里面还要控制下,栈为空,和在最后元素后面补充一个负数,保证全部数据都要得到合理计算的过程.然后用i-stack.peek()-1来处理宽度,
 * 因为当前高度是较小值,所以减一
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No084_Largest_Rectangle_in_Histogram {



    public int largestRectangleArea(int[] heights) {

        return 0;
    }
}
