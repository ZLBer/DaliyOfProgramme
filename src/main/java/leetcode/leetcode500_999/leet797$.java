package leetcode.leetcode500_999;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2019/1/16.
 */
public class leet797$ {
          //DFS
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            path.add(0);
            dfsSearch(graph, 0, res, path);
            return res;
        }
        private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
            if (node == graph.length - 1) {
                res.add(new ArrayList<Integer>(path));
                return;
            }
            for (int nextNode : graph[node]) {
                path.add(nextNode);
                dfsSearch(graph, nextNode, res, path);
                path.remove(path.size() - 1);
            }
        }
    }
