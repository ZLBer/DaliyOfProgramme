package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet1037 {
    //mine
 /*   public static boolean isBoomerang(int[][] points) {
        //相同点判断
        if(isSamePoint(points[0],points[1])||isSamePoint(points[0],points[2])||isSamePoint(points[1],points[2])) return false;
        //无限斜率判断
        if(isInfinite(points[0],points[1])&&isInfinite(points[1],points[2])) return false;
        if(isInfinite(points[0],points[1])||isInfinite(points[1],points[2])||isInfinite(points[0],points[2])) return true;
        float gradient[]=new float[2];
        gradient[0]=(float) (points[0][1]-points[1][1])/(points[0][0]-points[1][0]);
        gradient[1]=(float) (points[0][1]-points[2][1])/(points[0][0]-points[2][0]);
        if(gradient[0]==gradient[1])
            return false;
        return true;
    }

    //无限斜率判断
  static   boolean  isInfinite(int []pointsA,int [] pointsB){
        if(pointsA[0]==pointsB[0])
            return true;
        return false;
    }
    //相同点判断
 static    boolean isSamePoint(int []a,int []b){
        if(a[0]==b[0]&&a[1]==b[1]) return true;
        else return false;
    }*/


   //其实用交叉相乘可以省去很多麻烦
  static   public boolean isBoomerang(int[][] p) {
        return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
    }
    public static void main(String[] args) {
    isBoomerang(new int[][]{
            {0,1},{1,1},{2,2}
    });
    }
}
