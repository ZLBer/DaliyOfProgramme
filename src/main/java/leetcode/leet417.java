package leetcode;

import java.util.*;

public class leet417 {

    //逆向操作
     int [][]moves={{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res=new ArrayList<>();
        if(matrix.length==0) return res;
        boolean[][]canPacific=new boolean[matrix.length][matrix[0].length];
        boolean [][]canAtlantic=new boolean[matrix.length][matrix[0].length];

        Queue<int[]> queue=new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            queue.add(new int[]{i,0});
        }
        for (int i = 1; i < matrix[0].length; i++) {
            queue.add(new int[]{0,i});
        }

        BFS(matrix,queue,canPacific);

        for (int i = 0; i < matrix.length; i++) {
            queue.add(new int[]{i,matrix[0].length-1});
        }
        for (int i = 0; i < matrix[0].length-1; i++) {
            queue.add(new int[]{matrix.length-1,i});
        }
        BFS(matrix,queue,canAtlantic);



        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
              if(canPacific[i][j]&&canAtlantic[i][j]) res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }

    void BFS(int [][]matrix,Queue<int[]> queue,boolean [][] can){
     //   boolean [][]visited=new boolean[matrix.length][matrix[0].length];
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0){
                int[]p=queue.poll();
                can[p[0]][p[1]]=true;
              //  visited[p[0]][p[1]]=true;
                for (int i = 0; i < moves.length; i++) {
                    int x=p[0]+moves[i][0];
                    int y=p[1]+moves[i][1];
                    if(x>=0&&x<matrix.length&&y>=0&&y<matrix[0].length&&!can[x][y]&&(matrix[p[0]][p[1]]<=matrix[x][y])){
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
    }

  //the same
 /*   int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for(int i=0; i<n; i++){ //Vertical border
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m-1});
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
        }
        for(int i=0; i<m; i++){ //Horizontal border
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n-1, i});
            pacific[0][i] = true;
            atlantic[n-1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
    public void bfs(int[][]matrix, Queue<int[]> queue, boolean[][]visited){
        int n = matrix.length, m = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d:dir){
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];
                if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }*/


     //DFS版本
   /* public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][]pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];
        for(int i=0; i<n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for(int i=0; i<m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i,j));
        return res;
    }

    int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int[]d:dir){
            dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
        }
    }*/


    //不采用逆流  用四个状态来保存
   /* public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        int[][] state = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            state[i][0] |= 1;
            if (i == m - 1 || n == 1) state[i][0] |= 2;
            if (state[i][0] == 3) res.add(Arrays.asList(i,0));
            q.add(new int[]{i, 0});
            if (n > 1) {
                state[i][n - 1] |= 2;
                if (i == 0) state[i][n - 1] |= 1;
                if (state[i][n - 1] == 3) res.add(Arrays.asList(i,n-1));
                q.add(new int[]{i, n - 1});
            }
        }
        for (int j = 1; j < n - 1; j++) {
            state[0][j] |= 1;
            if (m == 1) state[0][j] |= 2;
            if (state[0][j] == 3) res.add(Arrays.asList(0,j));
            q.add(new int[]{0, j});
            if (m > 1) {
                state[m - 1][j] |= 2;
                if (state[m - 1][j] == 3)res.add(Arrays.asList(m-1,j));
                q.add(new int[]{m - 1, j});
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : dirs) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                if (row < 0 || col < 0 || row == m || col == n || matrix[row][col] < matrix[cell[0]][cell[1]] || ((state[cell[0]][cell[1]] | state[row][col]) == state[row][col])) continue;
                state[row][col] |= state[cell[0]][cell[1]];
                if (state[row][col] == 3) res.add(Arrays.asList(row,col));
                q.add(new int[]{row, col});
            }
        }
        return res;
    }*/
}
