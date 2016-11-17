package adm.com.ch05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tclresearchamerica on 11/16/16.
 * status of vertex: undiscovered, discovered & processed
 * parent of vertex u:
 * Two Points to remember when using BFS to find a shortest path from x to y;
 * 1. iff BFS was performed with x as the root of the search
 * 2. iff the graph is unweighted.
 */
public class BFS {
    public int MAXV = 1000;
    public boolean[] processed = new boolean[MAXV + 1];
    public boolean[] discovered = new boolean[MAXV + 1];

    //重要,parent数组提供了find 路径(须知道起点和终点)的最佳方法
    //因为节点可有多个子节点,但至多只有一个父节点,所以可以通过子节点回溯到父节点
    public int[] parent = new int[MAXV + 1];

    public int totalEdge = 0;

    public void initializeSearch(GraphStructure.Graph graph) {
        int i;
        for (i = 1; i < graph.nVertexes; i++) {
            processed[i] = discovered[i] = false;
            parent[i] = -1;//父节点为空
        }
    }

    public void findPath(int start, int end, int parents[]) {
        //boundary check
        if (start == end || end == -1) {
            System.out.printf("\n%d", start);
        } else {
            findPath(start, parents[end], parents);
            System.out.printf(" %d", end);
        }
    }


    public void bfs(GraphStructure.Graph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();/* queue of vertices to visit */

        int v;/* current vertex */
        int y;/* successor vertex */
        GraphStructure.EdgeNode p = null; /* temporary pointer */
        this.totalEdge = 0;

        queue.offer(start);//
        discovered[start] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            //before dealing
            processVertexEarly(v);
            //将v标志为已经处理
            processed[v] = true;
            //取得该节点的第一个元素的指针
            p = graph.edgeNodes[v];

            while (p != null) {
                //取得邻接节点
                y = p.y;

                if (processed[y] == false || graph.isDirected) {
                    processEdge(v, y);
                }

                if (discovered[y] == false) {
                    queue.offer(y);
                    //对发现的节点进行相关设置
                    discovered[y] = true;
                    //设置该节点的父节点
                    parent[y] = v;

                }
            }
            //循环处理完相邻节点后,对当前节点进行回归处理
            processVertexLate(v);

        }

    }

    public void processVertexLate(int v) {

    }

    public void processVertexEarly(int v) {
        System.out.println("processed vertex " + v);
    }

    public void processEdge(int v, int y) {
        System.out.printf("processed edge (%d,%d)\n", v, y);

        //当然,也可以进行相关操作,例如统计边的个数
        this.totalEdge++;
    }

}
