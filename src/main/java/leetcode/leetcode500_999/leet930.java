package leetcode.leetcode500_999;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by libin on 2019/4/14.
 */
public class leet930 {


 /*   //mine  Time Limit Exceeded  算法是对的，但是超麻烦，而且超时了
 static    public int numSubarraysWithSum(int[] A, int S) {

        List<Integer> list=new LinkedList<>();
        //记录index

        //0，2，4
        //0，1，2
        int res=0;
        for (int i = 0; i < A.length; i++) {
             if(A[i]==1) list.add(i);
        }
     if(list.size()<S) return 0;
     if(S==0) {
       if(list.size()==0) return count(A.length);
          //0,0,1,0,0
          //0,1,2,3,4,
       int left=0;
      int right=list.get(0);
      int temp=1;
      res += count(right - left);
      while (temp<list.size()) {
          left = right + 1;
          right = list.get(temp++);
          res += count(right - left);
      }
         res+=count(A.length-1-list.get(list.size()-1));

         return res;
     }
        for(int i=0;i+S-1<list.size();i++){
            int left=list.get(i)-1;
            int right=list.get(i+S-1)+1;
            int countLeft=1;
            int countRight=1;
            while (left>=0&&A[left]==0){
                left--;
                countLeft++;
            }
            while (right<A.length&&A[right]==0) {
                right++;
                countRight++;
            }
            res+=countLeft*countRight;
        }
return res;
    }



   static   int  count(int num){
     int sum=0;
     for(int i=0;i<=num;i++){
sum+=i;
     }
     return sum;
    }
*/
  static  public int numSubarraysWithSum(int[] A, int target) {
        Map<Integer, Integer> presum = new HashMap<>();
        //Prefix sum
        int sum = 0;
        //Answer
        int total = 0;
        for (int i = 0; i < A.length; i++){
            sum += A[i];
            if (presum.get(sum - target) != null){
                total += presum.get(sum - target);
            }
            if (sum == target) total++;
            //Also put this sum into the map as well
            presum.put(sum, presum.getOrDefault(sum, 0) + 1);
        }

        return total;

    }
    public static void main(String[] args) {
        numSubarraysWithSum(new int[]{1,0,1,0,1},2);
    }
}
