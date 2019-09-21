package leetcode.leetcode500_999;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/3/8.
 */
public class leet989 {
    //溢出了
//   static public List<Integer> addToArrayForm(int[] A, int K) {
//       int left=0;
//        for(int i=0;i<A.length;i++){
//        left=left*10+A[i];
//       }
//    //   System.out.println(Integer.MAX_VALUE);
//      // System.out.println(left);
//       int sum=K+left;
//       List<Integer> result=new LinkedList<>();
//        while (sum!=0){
//           result.add(0,sum%10);
//           sum/=10;
//        }
//return result;
//    }
    //mine  不转成int直接算
    static public List<Integer> addToArrayForm(int[] A, int K) {
       int i=A.length-1;
        List<Integer> result=new LinkedList<>();
       // List<Integer> result=new ArrayList<>();  这里不用ArrayList ，因为涉及到都是头插  ArrayList 46ms  LinkedList 9ms 差距很大
          while (K!=0&&i>=0){
             int sum=K%10+A[i];
              int jinwei=sum/10;
              int benwei=sum%10;

              result.add(0,benwei);
              K/=10;
              K=K+jinwei;
              i--;
          }

          while (i>=0){
              result.add(0,A[i]);
         i--;
          }

          while (K>0){
              result.add(0,K%10);
              K/=10;
          }
          return result;
    }

//With one loop
   /* public List<Integer> addToArrayForm(int[] A, int K) {
        List res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0 || K > 0; --i) {
            res.add(0, (i >= 0 ? A[i] + K : K) % 10);
            K = (i >= 0 ? A[i] + K : K) / 10;
        }
        return res;
    }*/

    public static void main(String[] args) {
        addToArrayForm(new  int[]{1,2,0,0},34);
    }
}
