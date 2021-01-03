package leetcode;

import java.util.Arrays;

public class leet853 {

    //mine 排序后倒序遍历  记录每一段最慢的就ok
    public int carFleet(int target, int[] position, int[] speed) {
      int [][]arr=new  int[position.length][2];

      if(position.length==0)return 0;
        for (int i = 0; i < position.length; i++) {
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        int res=1;
         int []pre=arr[arr.length-1];
        for (int i = arr.length-2; i >=0; i--) {
           int[]cur=arr[i];
          if(pre[0]==cur[0]||((pre[0]>cur[0])&&((target-pre[0])/(double)pre[1])>=((target-cur[0])/(double)cur[1]))){
              continue;
          }
          else {
             pre=cur;
              res++;
          }
        }
       return res;
    }


}
