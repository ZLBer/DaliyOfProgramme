package leetcode;

import java.util.concurrent.*;

public class leet718$ {
/*    public int findLength(int[] A, int[] B) {
      if(A==null||B==null) return 0;
      int m=A.length,n=B.length;
      int [][]dp=new int[m+1][n+1];
      int maxSum=0;
      for(int i=0;i<m+1;i++){
          for(int j=0;j<n+1;j++){
              if(i==0||j==0){
                  dp[i][j]=0;
              }else {
                  if(A[i-1]==B[j-1]){
                      dp[i][j]=1+dp[i-1][j-1];
                      maxSum=Math.maxSum(dp[i][j],maxSum);
                  }
              }
          }
      }
      return maxSum;
    }*/

    //改成一维数组 自己写的
    public int findLength(int[] A, int[] B) {
        if(A==null||B==null) return 0;
        int m=A.length,n=B.length;
        int []dp=new int[n+1];
        int max=0;
        for(int i=0;i<m+1;i++){
            //这层遍历用倒叙  保证状态不被覆盖
            for(int j=n;j>=0;j--){
                if(i==0||j==0){
                    dp[j]=0;
                }else {
                    if(A[i-1]==B[j-1]){
                        dp[j]=1+dp[j-1];
                        max=Math.max(dp[j],max);
                    //要让不符合条件的赋值为0
                    }else dp[j]=0;
                }
            }
        }
        return max;
    }



    //最直接的办法
/*    public int findLength(int[] A, int[] B) {
        int l1 = A.length, l2 = B.length, ans = 0;
        if (l1 == 0 || l2 == 0)
            return 0;
        HashMap< Integer, List< Integer >> map = new HashMap < > ();
        List < Integer > list;
        //存index
        for (int i = 0; i < l1; i++) {
            int n = A[i];
            list = map.getOrDefault(n, new ArrayList<Integer>());
            list.add(i);
            map.put(n, list);
        }


        //依次次比较
        for (int i = 0; i < l2 && l2-i > ans; i++) {
            int n = B[i];
            if (map.containsKey(n)){
                list = map.get(n);
                for (int m: list) {
                    //此处有剪枝
                    if (l1 - m < ans)
                        break;
                    int count = 1, k = m + 1;
                    for (int j = i + 1; j < l2 && k < l1; j++, k++) {
                        if (B[j] == A[k]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    ans = Math.maxSum(ans, count);
                }
            }
        }

        return ans;
    }*/
    public static void main(String[] args) {

       ExecutorService service= Executors.newFixedThreadPool(10);
    // service.execute();
        Future<Integer> future= service.submit(new Callable<Integer>() {
         @Override
         public Integer call() throws Exception {
             return 0;
         }
     });
        ExecutorCompletionService service1=new ExecutorCompletionService(service);
     }
}
