package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class leet1537 {


    //mine
    //写的好麻烦  应该可以简化
    //很重要的一点  比较大小之前不要取余
/*  static   public int maxSum(int[] nums1, int[] nums2) {

    Integer [] to2=new Integer[nums1.length];
  Integer[]  to1=new Integer[nums2.length];

    int i=0,j=0;
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                to2[i]=j;
                to1[j]=i;
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else {
                i++;
            }
        }
   dp=new Long[2][Math.max(nums1.length,nums2.length)];
   return (int)Math.max(dfs(true,true,0,to2,to1,nums1,nums2)%mod,dfs(false,false,0,to2,to1,nums1,nums2)%mod);
    }

  static   int mod=100_000_0007;
   static Long [][]dp;
 static   long dfs(boolean onOne,boolean  fromOne,int index,Integer[]to2,Integer[]to1,int []nums1,int []nums2){
     if(onOne){
       if(index>=nums1.length) return 0;

      if(dp[0][index]!=null){
          if(to2[index]!=null){
              return Math.max(dp[0][index],dp[1][to2[index]]);
          }
          return dp[0][index];
      }
       long cost=0;
      if(to2[index]!=null&&fromOne){ //有通道去nums2
        cost= dfs(false,true,to2[index],to2,to1,nums1,nums2);
      }

      //依然走nums1
       cost=Math.max(cost,dfs(true,true,index+1,to2,to1,nums1,nums2)+nums1[index]);
         //cost%=mod;
       //  System.out.println("0"+" "+index+" "+cost);

         return dp[0][index]=cost;
     }else{
        if(index>=nums2.length) return 0;

         if(dp[1][index]!=null )  {
             if(to1[index]!=null){
                return Math.max(dp[1][index],dp[0][to1[index]]);
             }
             return dp[1][index];
         }
         long cost=0;
        if(to1[index]!=null&&!fromOne){
            cost=dfs(true,false,to1[index],to2,to1,nums1,nums2);
        }
        cost=Math.max(cost,dfs(false,false,index+1,to2,to1,nums1,nums2)+nums2[index]);
      //   cost%=mod;
         //System.out.println("1"+" "+index+" "+cost);
       return  dp[1][index]=cost;
       }

}
*/

   //看看人家的多简洁   哭了
    //太妙了简直
    //但居然比我的慢这么多  哈哈哈 190ms 30ms
     int M = (int)1e9+7;
     public int maxSum(int[] nums1, int[] nums2) {
         Map<Integer, List<Integer>> map= new HashMap<>();

         //把nums1和nums2融合到一条链中 ，就不用有我那个判断了
         for (int i=0; i<nums1.length-1; i++)
             map.computeIfAbsent(nums1[i], k -> new LinkedList<>()).add(nums1[i+1]);
         for (int i=0; i<nums2.length-1; i++)
             map.computeIfAbsent(nums2[i], k -> new LinkedList<>()).add(nums2[i+1]);
         Map<Integer, Long> memo = new HashMap<>();
         return (int)Math.max(greedy(nums1[0], map, memo)%M, greedy(nums2[0], map, memo)%M);
     }

     long greedy(int cur, Map<Integer, List<Integer>> map, Map<Integer, Long> memo){
         if (memo.containsKey(cur)) return memo.get(cur);
         if (!map.containsKey(cur)) return cur;  //到达末尾
         long maxSum=0;
         for (int next: map.get(cur)){
             maxSum = Math.max(maxSum, greedy(next, map, memo));
         }
         maxSum+=cur;
         memo.put(cur, maxSum);
         return maxSum;
     }



     //直接法 5ms
/*    public int maxSum(int[] A, int[] B) {
        int i = 0, j = 0, n = A.length, m = B.length;
        long a = 0, b = 0, mod = (long)1e9 + 7;
        while (i < n || j < m) {
            if (i < n && (j == m || A[i] < B[j])) {
                a += A[i++];
            } else if (j < m && (i == n || A[i] > B[j])) {
                b += B[j++];
            } else {
                a = b = Math.max(a, b) + A[i];
                i++; j++;
            }
        }
        return (int)(Math.max(a, b) % mod);
    }*/


    public static void main(String[] args) {
      //  maxSum(new int[]{1,4,5,8,9,11,19},new int[]{2,3,4,11,12});
    }
}
