package leetcode.leetcode1000_1499;

public class leet1453$ {

    class Point{
       double x;
       double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
}


    double distance(double x1,double y1,double x2,double y2){
         return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    //求圆心的向量
    Point helper(Point a,Point b,int r){
       //计算ab中点
       Point mid=new Point((a.x+b.x)/2.0,(a.y+b.y)/2.0);
       //ab距离一半
       double d=distance(a.x,a.y,mid.x,mid.y);
       //计算垂线 h
       double h=Math.sqrt(r*r-d*d);
       //计算向量
      Point  ba=new Point(b.x-a.x,b.y-a.y);
      Point hd=new Point(-ba.y,ba.x);
     //向量长度
      double len=Math.sqrt(hd.x*hd.x+hd.y*hd.y);
      hd.x/=len;hd.y/=len;
      hd.x*=h;hd.y*=h;
      return new Point(hd.x+mid.x,hd.y+mid.y);
    }
    public int numPoints(int[][] points, int r) {
 int n=points.length;
 int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(i==j){//一个点
             /*       int cnt=0;
                    for(int k=0;k<n;k++){
                        double tmp=distance(points[i][0],points[i][1],points[k][0],points[k][1]);
                        if(tmp<=r) cnt++;
                    }
                    ans=Math.max(cnt,ans);*/

             ans=Math.max(1,ans);
             continue;
                }else {
                    //两个点
                    //通过长度判断有没有圆心
                    double d=distance(points[i][0],points[i][1],points[j][0],points[j][1]);
                    if(d/2>r) continue;

                    Point a=new Point(points[i][0],points[i][1]),b=new Point(points[j][0],points[j][1]);
                    Point res=helper(a,b,r);
                    int cnt=0;
                    for(int k=0;k<n;k++){
                        double tmp=distance(res.x,res.y,points[k][0],points[k][1]);
                        if(tmp<=r) cnt++;
                    }
                    ans=Math.max(cnt,ans);

            }
        }

        }    return ans;
}
}
