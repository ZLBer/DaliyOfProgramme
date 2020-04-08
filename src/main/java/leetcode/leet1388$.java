package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class leet1388$ {


    //动态规划
/*
    public int maxSizeSlices(int[] slices) {

        return Math.max(helper(slices,0,slices.length-1),helper(slices,1,slices.length));
    }



    int  helper(int[]slices,int start,int end){
       int [][]dp=new int[slices.length/3][slices.length];
       int res=0;
        for (int i = 0; i < slices.length; i++) {
            dp[0][i]=slices[i];
        }
      for(int i=1;i<slices.length/3;i++){
          int tempMax=0;
        for(int j=start;j<end;j++){
            if(j>=start+2)tempMax=Math.max(dp[i-1][j-2],tempMax);
            dp[i][j]=tempMax+slices[j];
        }
      }
        for (int i = 0; i < slices.length; i++) {
            res=Math.max(dp[slices.length/3-1][i],res);
        }
      return res;
    }
*/




    //贪心算法 https://leetcode-cn.com/problems/pizza-with-3n-slices/solution/3n-kuai-pi-sa-by-leetcode-solution/
    //看了提示自己写的  不是很容易写，改了好久
 static    public int maxSizeSlices(int[] slices) {
        int length=slices.length;
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((a,b)->b[0]-a[0]);
        Node[] nodes=new Node[length];
        for (int i = 0; i < length; i++) {
           priorityQueue.add(new int[]{slices[i],i});
           nodes[i]=new Node(slices[i],i);
        }
        for (int i = 0; i < length; i++) {
             nodes[i].left=nodes[(i-1+length)%length];
             nodes[i].right=nodes[(i+1)%length];
        }

        Set<Integer> visited=new HashSet<>();
        int res=0;
        int count=0;
        while (count<slices.length/3){
           int []slice=priorityQueue.poll();

           if(visited.contains(slice[1])) continue;
           Node node=nodes[slice[1]];
           Node left=node.left;
           Node right=node.right;
           res+=node.val;
           visited.add(left.index);
           visited.add(right.index);
           //左右两边重新链接
           node.left=left.left;
           left.left.right=node;
           node.right=right.right;
           right.right.left=node;
           //更新值
           node.val=(left.val+right.val-node.val);
           count++;
           priorityQueue.offer(new int[]{node.val,node.index});
        }
        return res;
    }

    //环形链表结构
  static   class Node{
        int val;
       int index;
        Node left;
        Node right;

        public Node(int val,int index) {
            this.val = val;
            this.index=index;
        }

    }

    public static void main(String[] args) {
        maxSizeSlices(new int[]{1,2,3,4,5,6});
    }
}
