package leetcode.leetcode1000_1499;

import leetcode.TreeNode;

public class leet1439$ {

    //MLE
/*    PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
    List<Integer> list=new ArrayList<>();
    public int kthSmallest(int[][] mat, int k) {
    dfs(mat,0,0);
        Collections.sort(list);
       return list.get(k-1);
    }
  void dfs(int [][]mat,int deep,int sum){
        if(deep>=mat.length) {
            list.add(sum);
            return;
        }

       for(int i=0;i<mat[0].length;i++){
          dfs(mat,deep+1,sum+mat[deep][i]);
       }
  }*/


//暴力   一点不深奥的方法居然没想到？
/*    public int kthSmallest(int[][] mat, int k) {
   PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((a,b)->b-a);
        for (int c = 0; c < mat[0].length; c++) {
          priorityQueue.add(mat[0][c]);
          if(priorityQueue.size()>k){
              priorityQueue.poll();
          }
        }
        for (int r = 1; r < mat.length; r++) {
            PriorityQueue<Integer> nextPQ=new PriorityQueue<>((a,b)->b-a);
            for (int a: priorityQueue) {
                for (int c = 0; c < mat[0].length; c++) {
                    nextPQ.add(a+mat[r][c]);
                    if(nextPQ.size()>k){
                        nextPQ.poll();
                    }
                }  
            }
            priorityQueue=nextPQ;
        }
        return priorityQueue.poll();
    }*/


//二分+剪枝
    public int kthSmallest(int[][] mat, int k) {
    int m=mat.length,n=mat[0].length;
    int left=m,right=m*5000;
    while (left<=right){
        int mid=(left+right)/2;
        int cnt=helper(m,n,mat,0,0,mid,k);
        System.out.println(cnt);
      if(cnt>k){
            right=mid-1;
        }else left=mid+1;
    }
    return left;
    }

    int helper(int m,int n,int [][]mat,int r,int sum,int targetSum,int k){

        if(sum>targetSum) return 0;
        if(m==r) return 1;
        int count=0;
        for (int c = 0; c < n; c++) {
           int cnt=helper(m,n,mat,r+1,sum+mat[r][c],targetSum,k);
           if(cnt==0) break;
           count+=cnt;
           if(count>k) break;
        }
        return count;

    }


    public boolean isSubtree(leetcode.TreeNode s, leetcode.TreeNode t) {
        //从二叉树S中找到与树T相同的结点
        leetcode.TreeNode temp = dfs(s,t);
        if(temp == null)
            return false;
        return compare(temp,t);
    }

    public leetcode.TreeNode dfs(leetcode.TreeNode s, leetcode.TreeNode t){
        if(s ==  null)
            return null;
        if(s.val == t.val){
            return s;
        }
        return dfs(s.left,t)!=null ? dfs(s.left,t):dfs(s.right,t);
    }

    public boolean compare(leetcode.TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if(s.val != t.val){
            return false;
        }

        boolean is_left = compare(s.left,t.left);
        boolean is_right = compare(s.right,t.right);
        return is_left && is_right;
    }
}
