package google.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 2016/3/1.
 * Description:
 * 给出一个整数数组nums，重新排列nums使得nums[0] < nums[1] > nums[2] < nums[3]...
 * Example:
 * nums = [1, 5, 1, 1, 6, 4], 一个可能的答案是[1, 4, 1, 5, 1, 6]
 * 数据保证必定有解。
 * ******************************************
 * Solution:
 * 本题有一种简单的做法，先快速排序，然后把最小的一半依次放在奇数位上，最大的一半依次放在偶数位上。
 * 算法复杂度是快速排序的复杂度O(NlogN)。仔细思考后发现快速排序不是必要的，
 * 只需要找到中位数即可。利用快速排序的思想找中位数的期望时间复杂度是O(N)。为了防止相等的数放在一起，
 * 需要注意放置的顺序。笔者采用的方法是依nums长度分两种情况：若长度为奇数，把比中位数小的依次放在0,2,4,...位置，
 * 比中位数大的依次放在length-2,length-4,...位置；若长度为偶数，把比中位数小的依次放在length-2,length-4,...位置，
 * 比中位数大的依次放在1,3,5,...位置。其余位置填充中位数。这样可以保证中位数一定与较小与较大的数相邻（题目保证一定有解）。
 */
public class No002_Wiggle_Sort {
    public static void main(String[] args) {
//test
    }

    public List<Integer> numIslands(int m, int n, int[][] positions) {
        boolean[][] map = new boolean[m][n];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        List<Integer> list = new ArrayList<>();
        int island = 0;
        int[] fa = new int[m * n];

        //initialization
        for (int i = 0; i < m * n; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < positions.length; i++) {
            island++;
            map[positions[i][0]][positions[i][1]] = true;
            int x, y;
            int f = positions[i][0] * n + positions[i][1];
            for (int k = 0; k < 4; k++) {
                x = positions[i][0] + dir[k][0];
                y = positions[i][1] + dir[k][1];
                if (x >= 0 && x < m && y >= 0 && y < n && map[x][y] && getFather(fa, x * n + y) != f) {
                    fa[getFather(fa, x * n + y)] = f;
                    island--;
                }
            }
            list.add(island);
        }

        return list;
    }

    //disjoint-set and path compression
    public int getFather(int[] fa, int i) {
        if (fa[i] == i) {
            return i;
        }
        fa[i] = getFather(fa, fa[i]);//path compression
        return fa[i];
    }
}
