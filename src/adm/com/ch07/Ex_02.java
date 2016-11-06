package adm.com.ch07;

import java.util.List;

/**
 * Created by tclresearchamerica on 11/5/16.
 * Multisets问题,set中含有重复元素,求所有不重复的元素排列
 * KeyPoint:如何处理重复元素
 * ->
 * 1.pruning:
 * 2. presort the multisets
 *
 */
public class Ex_02 {
    public int solution_cout = 0;

    public void backtrack(int a[], int k, List<Integer> input) {
        int[] c = new int[input.size() + 1];//candidate会有n个,所以要射成n+1
        int[] ncandidates = new int[1];
        int i;

        //此处判断当前是否是一个Solution
        if (is_a_solution(a, k, input)) {
            //针对solution进行process
            process_solution(a, k);//-> process_solution(a, k, input);
        } else {
            //因为没有满足solution的条件,所以k要进行++处理,
            k = k + 1;
            //此处是动态地为这种情况,定制candidate,因为当前程序简单,所以candidate只有true/false两个选项
            construct_candidates(a, k, input, c, ncandidates);
            for (i = 0; i < ncandidates[0]; i++) {
                //将candidate的值付给a[k]
                a[k] = c[i];
                //此处,可以对input进行额外的处理,但是此处并没有必要
//                make_move(a, k, input);
                backtrack(a, k, input);
//                unmake_move(a, k, input);
//                if (finished) return;
            }
        }
    }

    //for constructing all subsets
    public boolean is_a_solution(int a[], int k, List<Integer> input) {
        return (k == input.size());
    }


    public void construct_candidates(int a[], int k, List<Integer> input, int c[], int[] ncandidates) {
        boolean[] in_sol = new boolean[input.size() + 1];
        int last;//last vertex on current path
//        edgenode * p;//temporary pointer

        for (int i = 1; i < k; i++) in_sol[a[i]] = false;//将所有已经找到的k个节点的结果进行标志
        //此处不必标志某节点是否,被使用过
        if (k == 1) {
            c[0] = 1;
            ncandidates[0] = 1;
        } else {
            ncandidates[0] = 0;
            last = a[k - 1];//最后一个节点
//            p = g.edges.[last]; //-->边们
//            while (p != null) {
//                if (!in_sol[p ->]) {
//                    c[ncandidates[0]] = p -> y;
//                    ncandidates[0]++;
//                }
//                p = p -> next;
//            }
        }

    }

    public void process_solution(int a[], int k) {

        solution_cout++;
    }

    public void generate_permutations(int n) {
        int[] a = new int[n + 1]; /*solution vector*/
        backtrack(a, 0, n);
    }
}
