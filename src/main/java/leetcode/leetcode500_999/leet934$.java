package leetcode.leetcode500_999;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libin on 2019/4/18.
 */
public class leet934$ {
    public int shortestBridge(int[][] A) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[A.length][A[0].length];
        boolean found = false;


        //先DFS找到其中一座岛屿
        for (int i = 0; i < A.length; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    dfs(dirs, queue, i, j, visited, A);
                    found = true;
                    break;
                }
            }
        }
        //BFS 理解为一层一层向外扩展
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] a = queue.poll();

                for (int[] dir : dirs) {
                    int i = a[0] + dir[0];
                    int j = a[1] + dir[1];
                    if (i >= 0 && j >= 0 && i < A.length && j < A[0].length && !visited[i][j]) {
                        if (A[i][j] == 1)
                            return step;
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            step++;
        }
        return 0;

    }


    void dfs(int[][] dirs, Queue<int[]> queue, int i, int j, boolean[][] visited, int[][] A) {
        if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || A[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(dirs, queue, i + dir[0], j + dir[1], visited, A);
        }
    }
}
