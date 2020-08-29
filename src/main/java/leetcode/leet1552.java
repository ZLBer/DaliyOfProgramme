package leetcode;

import java.util.Arrays;

public class leet1552 {
   static public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left=1,right=(position[position.length-1]-position[0])/(m-1);
        while (left<right){
           int mid=(left+right+1)/2;  //注意此处向上取整
      if(check(mid,position,m)){
        left=mid;
      }else {
        right=mid-1;
      }
        }
   return left;
    }
 static   boolean check(int mid,int[]position,int m){

        int pre=position[0]; //前一个球的位置一定是0
          m--;
       for (int i = 1; i < position.length&&m>0; i++) {
         if(position[i]-pre>=mid){
            pre=position[i];
            m--;
         }
       }
      return m==0;
   }

    public static void main(String[] args) {
     maxDistance(new int[]{1,2,3,4,7},3);
    }
}
