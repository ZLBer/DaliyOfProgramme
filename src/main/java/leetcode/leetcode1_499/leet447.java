package leetcode.leetcode1_499;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by libin on 2019/2/25.
 */
public class leet447 {

    //mine 三重循环..
   /* public int numberOfBoomerangs(int[][] points) {
        int result=0;
        for(int i=0;i<points.length;i++){
              for(int j=i+1;j<points.length;j++){
                  for(int k=j+1;k<points.length;k++){
                      System.out.println(i+"   "+j+"     "+k);
                      int a=(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                      int b=(points[k][0]-points[i][0])*(points[k][0]-points[i][0])+(points[k][1]-points[i][1])*(points[k][1]-points[i][1]);
                      int c=(points[k][0]-points[j][0])*(points[k][0]-points[j][0])+(points[k][1]-points[j][1])*(points[k][1]-points[j][1]);
                      if(a==b||a==c||b==c) result++;
                      System.out.println(i+"   "+j+"     "+k);
                      System.out.println(result);
                  }
              }
          }
          return result*2;
    }*/


//优化成n2
public int numberOfBoomerangs(int[][] points) {
    int res = 0;

    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<points.length; i++) {
        for(int j=0; j<points.length; j++) {
            if(i == j)
                continue;

            int d = getDistance(points[i], points[j]);
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        for(int val : map.values()) {
            res += val * (val-1);
        }
        map.clear();
    }

    return res;
}

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }

}
