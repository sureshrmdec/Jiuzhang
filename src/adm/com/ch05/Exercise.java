package adm.com.ch05;

/**
 * Created by tclresearchamerica on 11/17/16.
 */
public class Exercise {

    // 5-3:
    // Assuming there is an unique path between x and y, we add a new leaf z under y.
    // z is only connected to its parent y, so there is only one way from z to x that is z -> y->[unique path assumed]->x

    //5-4. Prove that in a breadth-first search on a undirected graph G,
    // every edge is either a tree edge or a cross edge,
    // where x is neither an ancestor nor descendant of y, in cross edge (x,y).
    //Answer:BFS路径中,如果x既不是y的祖先也不是y的孩子,也就意味着没有通过x找到y,也没有通过y找到x。那这个图就是一堆离散的点了?



}
