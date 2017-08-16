package OJ;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by arachis on 2017/8/16.
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */
public class Course_Schedule_II {

    /*
    * This question asks for an order in which prerequisite courses must be taken first. This prerequisite relationship reminds one of directed graphs.
    * Then, the problem reduces to find a topological sort order of the courses, which would be a DAG if it has a valid order.
    * */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initialiseGraph(incLinkCounts, adjs, prerequisites);
        return solveByBFS(incLinkCounts, adjs);
//        return solveByDFS(adjs);
    }

    /*
    * The first step is to transform it into a directed graph.
    * Since it is likely to be sparse,we use adjacency list graph data structure. 1 -> 2 means 1 must be taken before 2.
    * */
    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites){
        int n = incLinkCounts.length;
        while (n-- > 0) adjs.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }

    /*
    * How can we obtain a topological sort order of a DAG?
        We observe that if a node has incoming edges, it has prerequisites.
        Therefore, the first few in the order must be those with no prerequisites, i.e. no incoming edges.
        Any non-empty DAG must have at least one node without incoming links. You can draw a small graph to convince yourself.
        If we visit these few and remove all edges attached to them, we are left with a smaller DAG, which is the same problem. This will then give our BFS solution.
    */
    private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs){
        int[] order = new int[incLinkCounts.length];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < incLinkCounts.length; i++) {
            if (incLinkCounts[i] == 0) toVisit.offer(i);
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : adjs.get(from)) {
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0) toVisit.offer(to);
            }
        }
        return visited == incLinkCounts.length ? order : new int[0];
    }

}
