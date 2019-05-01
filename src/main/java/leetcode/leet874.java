package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet874 {
    public int robotSim(int[] commands, int[][] obstacles) {

        int [][]dirs={{0,1},{-1,0},{0,-1},{1,0}};
        Set<String> set=new HashSet<>();
int x=0,y=0;
int result=0;
        for(int[]a:obstacles){
     set.add(a[0]+","+a[1]);
        }
        //方向
         int d=0;
        for(int c:commands){
           if(c==-2){
               d++;
               if(d==4){
                   d=0;
               }
           }else if(c==-1){
               d--;
               if(d==-1){
                   d=3;
               }
           }
           else {
               while (c>0&&!set.contains((x+dirs[d][0])+","+(y+dirs[d][1]))){
                   x+=dirs[d][0];
                   y+=dirs[d][1];
                   c--;
               }
           }
           result=Math.max(result,x*x+y*y);
        }
        return result;
    }
}
