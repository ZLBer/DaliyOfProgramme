package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet1560 {
/*     public List<Integer> mostVisited(int n, int[] rounds) {
        int []count=new int[n+1];
        count[rounds[0]]++;
        for (int i = 0; i < rounds.length-1; i++) {
            int begin=rounds[i];
            int end=rounds[i+1];
          if(begin<=end){
              for(int j=begin+1;j<=end;j++){
                  count[j]++;
              }
          }else {
              for(int j=begin+1;j<=n;j++){
                  count[j]++;
              }
              for(int j=1;j<=end;j++){
                  count[j]++;
              }
          }

        }

        int max=0;
        for (int i = 0; i < count.length; i++) {
            max=Math.max(count[i],max);

        }

        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if(count[i]==max)
            res.add(i);
        }
        return res;
    }*/


    //简化  只看首尾即可
    public List<Integer> mostVisited(int n, int[] rounds) {
        //终点和起点相关
        List<Integer> res = new ArrayList<>();
        int len = rounds.length;
        int left = rounds[0];
        int right = rounds[len -1];
        if(right >= left){
            for(int i = left; i <= right; i++){
                res.add(i);
            }
        }else{
            //求并集
            for(int i = 1; i <= right; i++){
                res.add(i);
            }
            for(int i = left; i <= n; i++){
                res.add(i);
            }

        }
        return res;

    }
    public static void main(String[] args) {
   //    mostVisited(4,new int[]{1,3,1,2});
    }
}
