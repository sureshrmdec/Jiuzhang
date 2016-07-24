package leetcode.com.pickup1.medium;

/**
 * Created by tclresearchamerica on 7/20/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/unique-binary-search-trees/
 * ****************************************************
 * Description:
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * ****************************************************
 * Thoughts:
 * 1.从2个节点来推论,1个作为根,另一个作为左或右子树,那么就有2种
 * 新增节点的话,这个新的点可以作为根,那么原来的节点就是左,右子树,
 * 如果原来的树作为根,新增点作为叶子的话,要保证不同构,新树的高度就是不能喝上面的一样?
 * ****************************************************
 * 网络答案:
 * Ref:https://segmentfault.com/a/1190000003811919
 * 二叉搜索树有个性质，就是左边的数都比根小，右边的数都比根大。另外，题目说明二叉树的节点是从1到n，所以我们能确定如果根为k，
 * 则根左边的数是1到k-1，根右边的数是k+1到n。还有一点技巧是，对于通过一个根来说，唯一二叉树的数量是其左子树的数量乘以右子树的数量，
 * 这是简单的乘法原理。并且，左右子树的形态数量是跟具体的数无关的，只跟这个树里有多少节点有关。而根可以选择从1到n的任意的数，
 * 唯一二叉树的总数，就是根为1到n的树相加。所以该问题化简为以k为根，其唯一左子树和右子树各有多少，这就是个动态规划的问题了。
 * 我们建立一个数组dp[i]，代表节点数为i的唯一子树有多少个。显然dp[0]=dp[1]=1。
 * ****************************************************
 * Time: 25 mins
 * Beat: 13%
 * Bug:1
 * ****************************************************
 * Hindsight:
 * 1.再次看了答案,才明白问题的算法是如何实现的。
 * 2.BST的特点要明白,就是左节点小于右节点
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No096_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            ////计算根是第一个数的BST数量，直到根是最后一个数的BST数量，这里j可以理解为根左边的节点数
            for (int j = 0; j < i; j++) {
                //有n的节点的BST一共有 G(n)=F(1,n-1)+F(2,n-1)+...+F(n-1,n-1)个
                //以i为根总共n个节点的BST有 F(i,n)=G(i-1)*G(i+1->n)个
                //BST形态数量之和一共有多少个节点有关 G(i+1->n)=G(n-i)
                //所以G(n)= G(0)*G(n-1)+G(1)*G(n-2)+...
                //bug:没有进行累加
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}