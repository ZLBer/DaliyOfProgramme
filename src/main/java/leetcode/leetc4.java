package leetcode;

import java.util.*;

public class leetc4 {
    public int minimumDistance(String word) {
      int[][]dp=new int[26][26];
      dp[0][1]=0;
      dp[1][0]=0;
      for(int i=2;i<word.length();i++){
         //移动第一个手指,第二个手指一定在i-1
          for(int j=0;j<i;j++){

          }

          int min=Integer.MAX_VALUE;
          for(int j=0;j<i-1;j++){
              int dis=distance(word.charAt(j),word.charAt(j));
             min=Math.min(dp[i-1][j]+dis,dp[j][i-1]+dis);
          }

      }
      return  0;
    }
    int distance(char a,char b){
        a-='A';b-='B';
      return   Math.abs(a/6-b/6)+Math.abs(a%6-b%6);
    }
    static {
        List<Integer> list = new ArrayList<>();
        Arrays.asList();
        Class c=int.class;
        PriorityQueue priorityQueue=new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }
}
