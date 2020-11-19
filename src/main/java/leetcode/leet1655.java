package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet1655 {

    //TLE
  /*  public boolean canDistribute(int[] nums, int[] quantity) {
      Map<Integer,Integer> map=new HashMap<>();

        for (int num : nums) {
           map.put(num,map.getOrDefault(num,0)+1);
        }
        int []count=new int[map.size()];
        int i=0;
        for (Integer value : map.values()) {
           count[i++]=value;
        }
       return dfs(0,quantity,count);
    }
    Map<String,Boolean> memo=new HashMap<>();
   boolean dfs(int q,int[]quantity,int []count){
      if(q>=quantity.length) return true;

      int need=quantity[q];

      String key=helper(q,count);

      if(memo.containsKey(key)) return memo.get(key);

      boolean flag=false;
       for (int i = 0; i < count.length; i++) {
         if(count[i]>=need){
             count[i]-=need;
          flag=dfs(q+1,quantity,count);
             count[i]+=need;
         }

         if(flag){
            memo.put(key,true);
             return true;
         }
       }

       memo.put(key,false);
       return false;
   }

   String helper(int q,int[] count){
      StringBuilder sb=new StringBuilder();

      sb.append(q+" ");

       for (int i = 0; i < count.length; i++) {
           sb.append(count[i]+" ");
       }
       return sb.toString();
   }
*/



  //啊啊啊啊 好激动  差不多是自己做出来的
    //就是状态压缩+枚举子集
    
/*
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer,Integer> map=new HashMap<>();

        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int []count=new int[map.size()];
        int aa=0;
        for (Integer value : map.values()) {
            count[aa++]=value;
        }

        int len=1<<quantity.length;


        boolean[][]dp=new boolean[count.length+1][len];

        dp[0][0]=true;

        for (int i = 1; i < dp.length; i++) {
            int con=count[i-1];
            dp[i][0]=true;
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j]=dp[i-1][j];
                if(dp[i][j]) continue;
                int state=j;
                if(helper(state,quantity)<=con){
                    dp[i][state]=true;
                    continue;
                }
                for(int k = state;k>0 ;k = (k-1) & state){
                    int cur=k,pre=state^k;
                    if(helper(cur,quantity)<=con&&dp[i-1][pre]) {
                        dp[i][j]=true;
                        break;
                    }
                }
            }
        }

        return dp[dp.length-1][len-1];
    }
*/

     int helper(int i,int []quantity){
        int c=0;
        int res=0;
        while (i>0){
         if((i&1)==1){
             res+=quantity[c];
         }
         c++;
         i>>=1;
        }
        return res;
    }


    //优化一下代码
 /*    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer,Integer> map=new HashMap<>();

        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int []count=new int[map.size()];
        int aa=0;
        for (Integer value : map.values()) {
            count[aa++]=value;
        }




        int len=1<<quantity.length;
        map=new HashMap<>();
        map.put(0,0);

        for(int k = len-1;k>0 ;k = (k-1) & (len-1)){
            map.put(k,helper(k,quantity));
        }






        boolean[][]dp=new boolean[count.length+1][len];

        dp[0][0]=true;

        for (int i = 1; i < dp.length; i++) {
            int con=count[i-1];
            dp[i][0]=true;
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j]=dp[i-1][j];
                if(dp[i][j]) continue;
                int state=j;
                if(helper(state,quantity)<=con){
                    dp[i][state]=true;
                    continue;
                }
                for(int k = state;k>0 ;k = (k-1) & state){
                    int cur=k,pre=state^k;
                    if(map.get(cur)<=con&&dp[i-1][pre]) {
                        dp[i][j]=true;
                        break;
                    }
                }
            }
        }

        return dp[dp.length-1][len-1];
    }*/


    //别人的优化 主要是针对前期存状态时候的优化
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer,Integer> map=new HashMap<>();

        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int []count=new int[map.size()];
        int aa=0;
        for (Integer value : map.values()) {
            count[aa++]=value;
        }




        int m=quantity.length;
        int len=1<<quantity.length;

        int []sum=new int[len];
        for (int i = 1; i < (1 << m); i++) {
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    int left = i - (1 << j);
                    sum[i] = sum[left] + quantity[j];
                    break;
                }
            }
        }




        boolean[][]dp=new boolean[count.length+1][len];

        dp[0][0]=true;

        for (int i = 1; i < dp.length; i++) {
            int con=count[i-1];
            dp[i][0]=true;
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j]=dp[i-1][j];
                if(dp[i][j]) continue;
                int state=j;
                if(sum[state]<=con){
                    dp[i][state]=true;
                    continue;
                }
                for(int k = state;k>0 ;k = (k-1) & state){
                    int cur=k,pre=state^k;
                    if(sum[cur]<=con&&dp[i-1][pre]) {
                        dp[i][j]=true;
                        break;
                    }
                }
            }
        }

        return dp[dp.length-1][len-1];
    }

    public static void main(String[] args) {
 /*       int state = 13; // 01101
        for(int k = state;k>0 ;k = (k-1) & state){
            System.out.println(Integer.toBinaryString(k)+" "+Integer.toBinaryString(state^k));
        }*/
    int []quantity=new int[]{2,2};
// canDistribute(new int[]{420,420,420,235,687,420,420,591,759,420,420,420,326,756,420,376,420,989,387,212,420,89,420,420,326,420,420,420,387,387},new int[]{1,3,1,4});
    }
}
