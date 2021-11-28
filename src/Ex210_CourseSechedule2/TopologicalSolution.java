package Ex210_CourseSechedule2;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 应该是在上一题的基础上, 加入stack, 进行记录
 * 因为可以找到结果的基础, 首先不能有cycle, 所以前一问的detecting cycle可以直接拿过来用
 * 需要注意, A课程的前置课程是B, 表示为[A,B], 所以添加Require的时候, 需要改为: courses[B].add[A], 表示读完B课程可以处理A
 */
public class TopologicalSolution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. adding all edges for each node
        List<Integer>[] courseRequires = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courseRequires[i] = new ArrayList<>();
        }
        // special here, need to add p[0] to p[1]
        for (int[] p : prerequisites) {
            courseRequires[p[1]].add(p[0]);
        }
        // 2. do dfs on each node
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int curCourse = 0; curCourse < numCourses; curCourse++) {
            // detected a cycle, return empty Array
            boolean[] processing = new boolean[numCourses];
            if (dfsDetectCycle(curCourse, courseRequires, processing, visited, stack)) {
                return new int[0];
            }
        }
        // 3. give it out
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public boolean dfsDetectCycle(int curCourse, List<Integer>[] courseRequires,
                                  boolean[] processing, boolean[] visited, Stack<Integer> stack) {
        // visited from another path
        if (visited[curCourse]) {
            return false;
        }
        // contains cycle in this path
        if (processing[curCourse]) {
            return true;
        }
        // set it become processing
        processing[curCourse] = true;
        // loop it's neighbors
        for (Integer i : courseRequires[curCourse]) {
            if (dfsDetectCycle(i, courseRequires, processing, visited, stack)) {
                return true;
            }
        }
        // no cycles, then set it not precessing, but visited;
        processing[curCourse] = false;
        visited[curCourse] = true;
        // we can add it into stack
        stack.push(curCourse);
        return false;
    }

    public static void main(String[] args) {
        TopologicalSolution test = new TopologicalSolution();
        int[][] edges = new int[1][2];
        edges[0][0] = 1;
        edges[0][1] = 0;
        int[] order = test.findOrder(2, edges);
        for (int i : order) {
            System.out.println(i);
        }
    }

}
