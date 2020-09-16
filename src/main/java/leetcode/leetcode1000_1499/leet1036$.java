package leetcode.leetcode1000_1499;

import java.util.HashSet;
import java.util.Set;

public class leet1036$ {
/*    int[][] dirs = new int[][]{{-1, 0},{1, 0}, {0, 1}, {0, -1}};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if(blocked.length==0){
            return true;
        }
        //存储blocked点
        Set<String> set = new HashSet<>();
        for(int[] ele: blocked){
            set.add(ele[0] + " " + ele[1]);
        }

        return checkHelper(set, source) && checkHelper(set, target);
    }


    public boolean checkHelper(Set<String> set, int[] source){
        int max_size = set.size();

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        //存储已经搜索过的点
        Set<String> seen = new HashSet<>();
        seen.add(source[0]+" "+source[1]);
        int level = 0;
        //bfs
        while(queue.size()!=0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] cur = queue.poll();
                for(int[] dir:dirs){
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];
                   //存储不是blocked 且 没有搜索过 且 不越界 的点
                    if(x>=0 && x<(int)(1e6) && y>=0 && y<(int)(1e6) && !seen.contains(x+" "+y) && !set.contains(x+" "+y)){
                        seen.add(x+" "+y);
                        queue.add(new int[]{x, y});
                    }
                }
            }
            //level其实是一层扩散
            //很关键的一个点，大于blocked.size 之后如果仍旧可以走，就不可能存在阻塞
            level++;
            if(level==max_size){
                break;
            }
            //如果没有点可以搜索
            if(queue.size()==0){
                return false;
            }
        }


        return true;
    }*/



//这个方法是dfs ，经过验证一定小于 MAX_VISIT
    final int MAX_VISIT = 20000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] ij : blocked) {
            String key = ij[0] + "," + ij[1];
            blockedSet.add(key);
        }
        return canVisit(blockedSet, source, target) && canVisit(blockedSet, target, source);
    }

    boolean canVisit(Set<String> blocked, int[] start, int[] end) {
        Set<String> visited = new HashSet<>();
        return dfs(blocked, start[0], start[1], end[0], end[1], visited);
    }

    boolean dfs(Set<String> blocked, int i, int j, int m, int n, Set<String> visited) {
        visited.add(i + "," + j);
        //如果找到目标点，或者大于指定搜索步数
        if (i == m && j == n || visited.size() >= MAX_VISIT) { return true; }
        for (int[] next : new int[][] {{i-1 ,j}, {i+1, j}, {i, j-1}, {i, j+1}}) {
            String nextKey = next[0] + "," + next[1];
            if (next[0] >= 0 && next[1] >= 0 && next[0] < 1e6 && next[1] < 1e6 && !blocked.contains(nextKey) && !visited.contains(nextKey)) {
                if (dfs(blocked, next[0], next[1], m, n, visited)) { return true; }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        leet1036$ leet=new leet1036$();
        int [][] blocked={
                {0,4},{1,3},{2,4},{3,3},{4,0},{4,2},{5,1}
        };
        System.out.println(leet.isEscapePossible(blocked,new int[]{0,0},new int[]{3,7}));
    }
}
