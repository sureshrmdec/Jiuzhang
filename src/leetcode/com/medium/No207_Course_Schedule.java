package leetcode.com.medium;

import java.util.LinkedList;
import java.util.Queue;

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
 * 画成图来还原这道题，就是课程关系中是否含有环
 */
public class No207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) return true;

        int len = prerequisites.length;

        if (numCourses == 0 || len == 0) return true;

        // counter for number of prerequisites
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < len; i++) {
            pCounter[prerequisites[i][0]]++;
        }

        //store courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) queue.add(i);
        }

        //number of courses that have no prerequisite
        int numNoPre = queue.size();


        while (!queue.isEmpty()) {
            int top = queue.remove();
            for (int i = 0; i < len; i++) {
                // if a course's prerequisite can be satisfied by a course in queue
                if (prerequisites[i][1] == top) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numNoPre == numCourses;
    }
}
