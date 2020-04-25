package leetcode.leetcode1000_;

public class leet1401$ {
/*    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {

        //圆心在正方形内部

        if(x_center>=x1&&x_center<=x2&&y_center>=y1&&y_center<=y2){
            return true;
        }
        //在正左边
        else if(x_center<x1&&y_center>y1&&y_center<y2){
            return (x1-x_center)<radius;

            //正右边
        }else if(x_center>x2&&y_center>y1&&y_center<y2){
            return (x_center-x2)<radius;
        //正上方
        }else if(y_center>y2&&x_center>x1&&x_center<x2){
            return (y_center-y2)<radius;

            //正下方
        }else if(y_center<y1&&x_center>x1&&x_center<x2){
            return (y1-y_center)<radius;
        }
        //斜着的
        //判断四个点在不在圆形内部即可
        else {
            if(((x1-x_center)*(x1-x_center)+(y1-y_center)*(y1-y_center))>radius*radius&&
                    ((x2-x_center)*(x2-x_center)+(y2-y_center)*(y2-y_center))>radius*radius&&
                    ((x2-x_center)*(x2-x_center)+(y1-y_center)*(y1-y_center))>radius*radius&&
                    ( (x1-x_center)*(x1-x_center)+(y2-y_center)*(y2-y_center))>radius*radius)
                return false;
            else return true;
        }
    }*/

    //利用向量来做
    //https://leetcode-cn.com/problems/circle-and-rectangle-overlapping/solution/circle-and-rectangle-overlapping-by-ikaruga/
  /*  public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
     //以正方形的中心作为原点
      double x0=(x1+x2)/2.0,y0=(y1+y2)/2.0;
      double[]p=new double[]{ Math.abs(x_center-x0),Math.abs(y_center-y0)};
      double[]q=new double[]{x2-x0,y2-y0};
      double[]u=new double[]{Math.max(p[0]-q[0],0.0),Math.max(p[1]-q[1],0.0)};

      return (u[0]*u[0]+u[1]*u[1])<=radius*radius;
    }*/



    //考虑最短距离
    //https://leetcode.com/problems/circle-and-rectangle-overlapping/discuss/563341/4-lines-C%2B%2B-O(1)%3A-Test-shortest-distance-from-center-to-rect-(with-pics)
    boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int edgeX = (x_center < x1) ? x1 : (x_center > x2) ? x2 : x_center;
        int edgeY = (y_center < y1) ? y1 : (y_center > y2) ? y2 : y_center;
        int distX = x_center - edgeX, distY = y_center - edgeY;
        return distX * distX + distY * distY <= radius * radius;
    }
}
