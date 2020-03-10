package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leet1368$ {
    //双端队列+BFS
    //进行bfs的同时对同一个方向的放在队首位，不同方向的放在队尾，自然就实现了cost从小到大进行访问
    int [][]next=new int[][]{
            {0,1},{0,-1},{1,0},{-1,0}
    };
   /* public int minCost(int[][] grid) {
        if(grid==null) return -1;

        Deque<Node> deque=new ArrayDeque<>();
        deque.offerFirst(new Node(0,0,0));
        boolean[][]visited=new boolean[grid.length][grid[0].length];
        visited[0][0]=true;
        while (!deque.isEmpty()){
            Node node=deque.pollFirst();
            if(node.x==grid.length-1&&node.y==grid[0].length-1)
                return node.cost;
            visited[node.x][node.y]=true;

            for(int i=0;i<4;i++){
                int x=node.x+next[i][0];
                int y=node.y+next[i][1];
                if(x>=0&&y>=0&&x<grid.length&&y<grid[0].length&&!visited[x][y]){
                    if(grid[node.x][node.y]==i+1){
                        deque.offerFirst(new Node(x,y,node.cost));
                    }else {
                        deque.offerLast(new Node(x,y,node.cost+1));
                    }
                }
            }

        }
        return -1;
    }
*/

    class Node{
        int x;
        int y;
        int cost; public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }



    //BFS+DFS  和上边想法是一样的 但实现不一样
    //基本方法就是  初始化阶段：找到不用改变就能访问到的节点，依次入队，然后对queue的每个节点依次改变方向在进行dfs找到能访问到的节点。然后进行下一轮拓展
    //对queue的访问就是bfs的过程，先访问的是cost小的节点，后访问cost大的节点。每次dfs都要cost++此时队列里的点都是cost相同的
    /*int[][] DIR = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length, cost = 0;
        Queue<int[]> bfs = new LinkedList<>();
        boolean [][]visited=new boolean[m][n];
        dfs(grid, 0, 0, visited, bfs);
        while (!bfs.isEmpty()) {
            cost++;
            for (int size = bfs.size(); size > 0; size--) {
                int[] top = bfs.poll();
                int r = top[0], c = top[1];
                if(r==m-1&&c==n-1)
                    return cost;
                for (int i = 0; i < 4; i++) dfs(grid, r + DIR[i][0], c + DIR[i][1], visited, bfs);
            }
        }
        return -1;
    }

    void dfs(int[][] grid, int r, int c, boolean[][] visited, Queue<int[]> bfs) {
        int m = grid.length, n = grid[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) return;
        visited[r][c]=true;
        bfs.offer(new int[]{r, c}); // add to try to change direction later
        int nextDir = grid[r][c] - 1;
        dfs(grid, r + DIR[nextDir][0], c + DIR[nextDir][1], visited, bfs);
    }*/


    //https://leetcode-cn.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/solution/zui-duan-lu-jing-suan-fa-bfs0-1bfsdijkstra-by-luci/
    //Dijkstra
    public int minCost(int[][] grid) {
        boolean [][]visited=new boolean[grid.length][grid[0].length];
        int[][]dist=new int[grid.length][grid[0].length];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Node> priorityQueue=new PriorityQueue<>(Comparator.comparing(a->a.cost));
        priorityQueue.offer(new Node(0,0,0));
        dist[0][0]=0;
        while (!priorityQueue.isEmpty()){
            Node node=priorityQueue.poll();
           // if(visited[node.x][node.y]) continue;
            visited[node.x][node.y]=true;
            for(int i=0;i<4;i++){
                int nx=node.x+next[i][0];
                int ny=node.y+next[i][1];
                int cost=node.cost;
                if(nx<0||ny<0||nx>=grid.length||ny>=grid[0].length||visited[nx][ny]) continue;

                if(grid[node.x][node.y]!=i+1) cost++;
                if(cost<dist[nx][ny]){
                   dist[nx][ny]=cost;
                    priorityQueue.offer(new Node(nx,ny,cost));
                }
            }
        }
        return dist[grid.length-1][grid[0].length-1];
    }


}
