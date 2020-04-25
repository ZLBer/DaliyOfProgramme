package leetcode.leetcode1000_;

public class leet1289 {

    //DFS超时了
    /*    public int minFallingPathSum(int[][] arr) {
       DFS(arr,0,-1,0);
       return min;
        }


        int min=Integer.MAX_VALUE;
       void DFS(int[][]arr,int deep,int preCol,int preSum){
          if(deep>=arr.length) {
              min=Math.min(preSum,min);
              return;
          }
          if(preSum>=min) return;
           //列序号
           for(int i=0;i<arr[0].length;i++){
              if(i==preCol) continue;
              DFS(arr,deep+1,i,preSum+arr[deep][i]);
          }
       }*/

    //mine contest 动态规划
/*    public int minFallingPathSum(int[][] arr) {
     int[][]dp=new int[arr.length][arr[0].length];
     for(int i=0;i<arr[0].length;i++){
         dp[0][i]=arr[0][i];
     }
     for(int row=1;row<arr.length;row++){
         //每个点都循环，效果很差
         for(int col=0;col<arr[0].length;col++){
             int cur=Integer.MAX_VALUE;
             for(int pre=0;pre<arr[0].length;pre++){
                 if(pre==col) continue;
                 cur=Math.min(cur,dp[row-1][pre]+arr[row][col]);
             }
             System.out.println(cur);
             dp[row][col]=cur;
         }
     }

     int res=Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            System.out.println(dp[dp.length-1][i]);
            res=Math.min(res,dp[dp.length-1][i]);
        }
        return res;
    }*/

    //和我的差不多，但不用额外的空间 也不用每次都判断if
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        for (int row=n-2;row>=0;row--) {
            for (int col=0;col<n;col++) {
                int min = Integer.MAX_VALUE;
                // Values to the left.
                for(int k=0;k<col;k++) {
                    min = Math.min(arr[row+1][k],min);
                }
                // Values to the right.
                for (int k=col+1;k<n;k++) {
                    min = Math.min(arr[row+1][k],min);
                }
                arr[row][col]+= min;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            result = Math.min(result, arr[0][i]);
        }
        return result;
    }



    //别人的动态规划
 /*   public int minFallingPathSum(int[][] arr) {
        for (int rowIndex = 1; rowIndex < arr.length; rowIndex++) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue();
            for (int colIndex = 0; colIndex < arr[0].length; colIndex++) {
                priorityQueue.offer(arr[rowIndex - 1] [colIndex]);
            }

            //杜绝了每个点都循环的情况
            int firstSmallest = priorityQueue.poll();
            int secondSmallest = priorityQueue.poll();
            for (int colIndex = 0; colIndex < arr[0].length; colIndex++) {
                //最小的失效
                if (arr[rowIndex - 1] [colIndex] == firstSmallest) {
                    arr[rowIndex] [colIndex] = arr[rowIndex] [colIndex] + secondSmallest;
                    //启用第二个
                } else {
                    arr[rowIndex] [colIndex] = arr[rowIndex] [colIndex] + firstSmallest;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        //遍历出结果
        for (int colIndex = 0; colIndex < arr[0].length; colIndex++) {
            result = Math.min(result, arr[arr.length - 1][colIndex]);
        }
        return result;
    }*/
}
