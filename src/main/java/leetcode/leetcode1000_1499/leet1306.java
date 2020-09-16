package leetcode.leetcode1000_1499;

import java.util.LinkedList;
import java.util.Queue;

public class leet1306 {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        if(arr[start]==0) return true;
        boolean [] visited=new boolean[arr.length];
        while (!queue.isEmpty()){
            int index=queue.poll();
            visited[index]=true;
            int nextR=index+arr[index];
            if(nextR<arr.length&&!visited[nextR]){
                if(arr[nextR]==0)
                    return true;
                else queue.add(nextR);
            }
            int nextL=index-arr[index];
            if(nextL>=0&&!visited[nextL]){
                if(arr[nextL]==0)
                    return true;
                else queue.add(nextL);
            }
        }
        return false;
    }
//递归 dfs
/*    public boolean canReach(int[] arr, int st) {
        if (st >= 0 && st < arr.length && arr[st] < arr.length) {
            int jump = arr[st];
            //就是标志已经访问了  重复访问没有意义
            arr[st] += arr.length;
            return jump == 0 || canReach(arr, st + jump) || canReach(arr, st - jump);
        }
        return false;
    }*/
}
