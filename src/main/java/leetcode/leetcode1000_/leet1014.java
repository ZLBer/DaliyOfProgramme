package leetcode.leetcode1000_;

/**
 * Created by libin on 2019/3/19.
 */
public class leet1014 {

    //遍历  Time Limited
//    public int maxScoreSightseeingPair(int[] A) {
//       int  maxScore=Integer.MIN_VALUE;
//        for(int i=0;i<A.length;i++){
//      for(int j=i+1;j<A.length;j++){
//          int sum=A[i]+A[j]+i-j;
//          maxScore=Math.max(sum,maxScore);
//      }
//  }
//
//  return maxScore;
//
//    }
    public int maxScoreSightseeingPair(int[] A) {
        int res=0,cur=0;
        for(int a:A) {
            res = Math.max(res, cur + a);  //res 存储结果
            cur = Math.max(cur, a) - 1;  //cur 代表当前最大，未加a
        }
        return res;
    }
}
