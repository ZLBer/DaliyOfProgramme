package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leet823 {

    //就简单dp吧
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
      Map<Integer,Long> map=new HashMap<>();
      int mod = (int) 1e9+7;
      map.put(A[0],1L);
      for(int i=1;i<A.length;i++){
          int num=A[i];
          Long count=1L;
          for(int j=0;j<i;j++){
         if(num%A[j]==0&&map.containsKey(num/A[j])){

               count=(count+(map.get(A[j])*map.get(num/A[j])))%mod;

         }
          }
          map.put(num,count);
      }
      long res=0;
        for (long value : map.values()) {
            res=(value+res)%mod;
        }
        return (int)res;
    }
}
