package Ex181_to_210.Ex207_CourseSechedule;

import java.util.*;

/**
 * 使用Topological的思想, 使用dfs进行再进行搜索,
 * 这里使用Boolean替代VisitedSet, ProcessingSet, 效率更高
 * 需要注意, 每次递归要找对元素
 */
public class TopologicalDfs {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. adding all edges for each node
        List<Integer>[] courseRequires = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courseRequires[i] = new ArrayList<>();
        }
        // [1,0], [1,2] -> 1:[0, 2]
        for (int[] p : prerequisites) {
            courseRequires[p[0]].add(p[1]);
        }
        // 2. do dfs on each node
        boolean[] processing = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int curCourse = 0; curCourse < numCourses; curCourse++) {
            // detected a cycle, return false
            if (dfsDetectCycle(curCourse, courseRequires, processing, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfsDetectCycle(int curCourse, List<Integer>[] courseRequires,
                                  boolean[] processing, boolean[] visited) {
        // visited from another path
        if (visited[curCourse]) {
            return false;
        }
        // contains cycle in this path
        if (processing[curCourse]) {
            return true;
        }
        // no path
        if (courseRequires[curCourse].size() == 0) {
            return false;
        }
        // set it become processing
        processing[curCourse] = true;
        // loop it's neighbors
        for (Integer i : courseRequires[curCourse]) {
            if (dfsDetectCycle(i, courseRequires, processing, visited)) {
                return true;
            }
        }
        // no cycles, then set it not precessing, but visited;
        processing[curCourse] = false;
        visited[curCourse] = true;
        return false;
    }

    public static void main(String[] args) {

        TopologicalDfs test = new TopologicalDfs();

//        int[][] edges = new int[5][2];
//        edges[0][0] = 2;
//        edges[0][1] = 0;
//        edges[1][0] = 1;
//        edges[1][1] = 0;
//        edges[2][0] = 3;
//        edges[2][1] = 1;
//        edges[3][0] = 3;
//        edges[3][1] = 2;
//        edges[4][0] = 1;
//        edges[4][1] = 3;

        int[][] edges = new int[1][2];
        edges[0][0] = 0;
        edges[0][1] = 1;

        System.out.println(test.canFinish(2, edges));

    }


}
