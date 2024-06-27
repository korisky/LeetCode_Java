package Ex1501_1800.Ex1791_FindCenterStarGraph;

public class Solution {

    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]
                ? edges[0][0]
                : edges[0][1];
    }
}
