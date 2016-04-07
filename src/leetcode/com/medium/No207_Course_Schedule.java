package leetcode.com.medium;

import java.util.*;

/**
 * Created by jason on 2016/4/4.
 * Location：
 * https://leetcode.com/problems/course-schedule/
 * **************************************************
 * Description：
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0
 * you should also have finished course 1. So it is impossible.
 * ***************************************************
 * Solution：
 * 画成图来还原这道题，就是课程关系中是否含有环,另一个比较简洁的解释是 所有节点的入度都为零
 */
public class No207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // init the adjacency list
        List<Set> posts = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            posts.add(new HashSet<>());

        //fill the adjacency list
        for (int i = 0; i < prerequisites.length; i++)
            // 将所有课程的前提课程存入hashset
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);

        //count the pre-courses
        //算出该课程是多少课程的前提课程
        int[] preNums = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            Set set = posts.get(i);
            Iterator<Integer> it = set.iterator();
            while (it.hasNext())
                preNums[it.next()]++;

        }


        // remove a non-pre course each time
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            for (; j < numCourses; j++)
                if (preNums[j] == 0) break;

            //if not a non-pre course
            if (j == numCourses) return false;

            preNums[j] = -1;

            //decrease course that post the course
            Set set = posts.get(j);
            Iterator<Integer> it = set.iterator();
            while (it.hasNext())
                preNums[it.next()]--;
        }
        return true;

    }
}
