package leetcode;

import java.util.*;

public class leet773 {
/*
   //mine 压缩成一维数组  queue里存数组 保存状态string
    int []move=new int[]{1,-1,3,-3};
    public int slidingPuzzle(int[][] board) {
      int []boards=new int[6];
      boards[0]=board[0][0];
        boards[1]=board[0][1];
        boards[2]=board[0][2];
        boards[3]=board[1][0];
        boards[4]=board[1][1];
        boards[5]=board[1][2];

        int init=0;
        for (int i = 0; i < boards.length; i++) {
            if(boards[i]==0){
                init=i;
                break;
            }
        }

        Queue<Status> queue=new LinkedList<>();
        queue.add(new Status(init,boards));
        Set<String> set=new HashSet<>();
        set.add(numToString(boards));
        int step=0;
        String target="123450";

        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0){
              Status status =queue.poll();
              if(numToString(status.boards).equals(target)) return step;

                for (int i : move) {
                   int next=status.index+i;
                    if(next>=0&&next<6){
                        if((i==1&&status.index==2)||(i==-1&&status.index==3)) continue;
                        int[]cp= Arrays.copyOf(status.boards,status.boards.length);
                        cp[status.index]=cp[next];
                        cp[next]=0;  //交换数组大小
                       String s=numToString(cp);
                       if(set.contains(s)) continue;
                       set.add(s);
                       queue.add(new Status(next,cp));
                    }
                }
            }
            step++;
        }
        return -1;

    }

    String numToString(int []num){
        StringBuilder sb=new StringBuilder();
        for (int i : num) {
            sb.append(i);
        }
        return sb.toString();
    }

    class Status{
        int index;
        int []boards;

        public Status(int index, int[] boards) {
            this.index = index;
            this.boards = boards;
        }
    }
*/

   //更直接一点  queue里存字符串
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        HashSet<String> visited = new HashSet<>();
        // all the positions 0 can be swapped to
        int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            // level count, has to use size control here, otherwise not needed
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return res;
                }
                int zero = cur.indexOf('0');
                // swap if possible
                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);

                }
            }
            res++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
