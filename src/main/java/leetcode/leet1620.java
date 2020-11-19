package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet1620 {

    //mine 就暴力呗..
    public int[] bestCoordinate(int[][] towers, int radius) {

        List<int[]> points = new ArrayList<>();
        //map用来存点和
        Map<String,Integer> map=new HashMap<>();
        for (int[] tower : towers) {
            //信号为0，忽略
            if(tower[2]==0) continue;
            //框出一个正方形
            for(int x=tower[0]-radius;x<=tower[0]+radius;x++){
               for(int y=tower[1]-radius;y<=tower[1]+radius;y++){
                   int dis=(x-tower[0])*(x-tower[0])+(y-tower[1])*(y-tower[1]);
                   //检测是否在radius范围里
                   if(dis<=radius*radius){
                       //之前未遍历过
                       if(!map.containsKey(x+" "+y)){
                           map.put(x+" "+y,points.size());
                           points.add(new int[]{x,y,(int)helper(tower[2],Math.sqrt(dis))});
                       //之前遍历过，增加信号强度
                       }else {
                           points.get(map.get(x+" "+y))[2]+=helper(tower[2],Math.sqrt(dis));
                       }

                   }
               }
            }
        }
       Collections.sort(points,(a,b)->b[2]!=a[2]?b[2]-a[2]:(a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]));
       if(points.size()==0) return new int[]{0,0};
       return new int[]{points.get(0)[0],points.get(0)[1]};
    }

    double helper(int q,double d){
       return  q/(1+d);
    }
}
