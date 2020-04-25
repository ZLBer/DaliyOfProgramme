package leetcode.leetcode500_999;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leet864 {


    //mine 关键在于状态的封装 x+y+钥匙
/*    int [][]move=new int[][]{
            {0,1},{0,-1},{1,0},{-1,0}
    };
    public int shortestPathAllKeys(String[] grid) {
        int keys=0;
        Point begin=new Point();
        //查找key的个数和起始位置
        for (int i = 0; i < grid.length; i++) {
          for(int j=0;j<grid[i].length();j++){
               char c=grid[i].charAt(j);
              if(c>='a'&&c<='z'){
                  keys++;
              }
              else if(c=='@'){
                   begin.x=i;begin.y=j;begin.state=new HashSet<>();
              }
          }
        }
        Set<String> visited=new HashSet<>();
        visited.add(begin.toString());
        Queue<Point> queue=new LinkedList<>();
        queue.offer(begin);
        int res=0;
        while (!queue.isEmpty()){
             int size=queue.size();
             res++;
             while (size-->0){
                 Point point=queue.poll();
                 for (int i = 0; i < move.length; i++) {
                     int tx=move[i][0]+point.x;
                     int ty=move[i][1]+point.y;
                     if(tx>=0&&ty>=0&&tx<grid.length&&ty<grid[0].length()){
                             char n=grid[tx].charAt(ty);

                         Point newPoint=new Point(tx,ty,new HashSet<>(point.state));
                         //墙
                             if(n=='#') continue;
                             //找到一把钥匙
                             else if(n>='a'&&n<='z'){
                                 newPoint.state.add(n-'a');

                             }
                             else if(n>='A'&&n<='Z'){
                                 if(!point.state.contains(n-'A')) continue;
                             }


                             if(newPoint.state.size()>=keys) return res;
                         if(visited.add(newPoint.toString())) queue.add(newPoint);
                     }
                 }
             }
        }



        return -1;
    }
    class Point{
        int x;
        int y;
        Set<Integer> state;//暂且代表钥匙


        public  Point(){

        }
        public Point(int x, int y,  Set<Integer> state) {
            this.x = x;
            this.y = y;
            this.state = state;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", state=" + state +
                    '}';
        }
    }*/



    //用位表示钥匙  节省了很多空间和时间啊
    class State {
        int keys, i, j;
        State(int keys, int i, int j) {
            this.keys = keys;
            this.i = i;
            this.j = j;
        }
    }
    public int shortestPathAllKeys(String[] grid) {
        int x = -1, y = -1, m = grid.length, n = grid[0].length(), max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                }
                if (c >= 'a' && c <= 'f') {
                    max = Math.max(c - 'a' + 1, max);
                }
            }
        }
        State start = new State(0, x, y);
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + x + " " + y);
        q.offer(start);
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                State cur = q.poll();
                if (cur.keys == (1 << max) - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int i = cur.i + dir[0];
                    int j = cur.j + dir[1];
                    int keys = cur.keys;
                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        char c = grid[i].charAt(j);
                        if (c == '#') {
                            continue;
                        }
                        if (c >= 'a' && c <= 'f') {
                            keys |= 1 << (c - 'a');
                        }
                        if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) {
                            continue;
                        }
                        if (!visited.contains(keys + " " + i + " " + j)) {
                            visited.add(keys + " " + i + " " + j);
                            q.offer(new State(keys, i, j));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }



  /*  //主要的想法是用三维数组来保存状态
    private int[] xd = new int[]{0, 0, 1, -1};
    private int[] yd = new int[]{1, -1, 0, 0};

    private class Node {
        int x;
        int y;
        int ks;
        public Node(int x, int y, int ks) {
            this.x = x;
            this.y = y;
            this.ks = ks;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        char[][] chars = new char[m][n];
        int x = -1, y = -1;
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                chars[i][j] = c;
                if (c == '@') {
                    x = i;
                    y = j;
                }
                else if (c >= 'a' && c <= 'f') {
                    k++;
                }
            }
        }
        int keys = 0;
        for (int i = 0; i < k; i++) {
            keys = addKey(keys, 'a' + i);
        }
        Queue<Node> queue = new LinkedList();
        boolean[][][] visited = new boolean[m][n][keys + 1];
        queue.offer(new Node(x, y, 0));
        visited[x][y][0] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.ks == keys) {
                    return cnt;
                }
                for (int j = 0; j < 4; j++) {
                    x = curr.x + xd[j];
                    y = curr.y + yd[j];
                    if (x < 0 || x >= m || y < 0 || y >= n || chars[x][y] == '#') {
                        continue;
                    }
                    char c = chars[x][y];
                    int ks = addKey(curr.ks, c);
                    if (visited[x][y][ks]) {
                        continue;
                    }
                    if (c >= 'A' && c <= 'F' && !unlock(curr.ks, c)) {
                        continue;
                    }
                    visited[x][y][ks] = true;
                    queue.offer(new Node(x, y, ks));
                }
            }
            cnt++;
        }
        return -1;
    }

    public int addKey(int keys, int c) {
        if (c >= 'a' && c <= 'f') {
            int index = c - 'a';
            return keys | (1 << index);
        }
        return keys;
    }

    public boolean unlock(int keys, int c) {
        int index = c - 'A';
        return (keys & (1 << index)) > 0;
    }*/


    public static void main(String[] args) {
   /*   new leet864().shortestPathAllKeys(new String[]{
              "@.a.#","###.#","b.A.B"
      });*/
    }
}
