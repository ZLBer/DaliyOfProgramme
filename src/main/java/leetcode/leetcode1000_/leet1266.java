package leetcode.leetcode1000_;

public class leet1266 {

    //mine firsit version
 /*   public int minTimeToVisitAllPoints(int[][] points) {

        int []pre=points[0];
        int res=0;
        for (int i = 1; i < points.length; i++) {
            int x=points[i][0];
            int y=points[i][1];
            if(x==pre[0]||y==pre[1]) res+=(Math.abs(x-pre[0])+Math.abs(y-pre[1]));
            else {

                //x轴逼近
                if(Math.abs(x-pre[0])<Math.abs(y-pre[1])){
                    int dis=(Math.abs(x-pre[0]));
                    res+=dis;
                    res+=(Math.abs(y-pre[1])-dis);
                    //y轴逼近
                }else {
                    int dis=(Math.abs(y-pre[1]));
                    res+=dis;
                    res+=(Math.abs(x-pre[0])-dis);
                }


            }

            pre=points[i];
        }


        return res;
    }
*/

  //mine 缩减为一种情况
/*    public int minTimeToVisitAllPoints(int[][] points) {

        int []pre=points[0];
        int res=0;
        for (int i = 1; i < points.length; i++) {
            int x=points[i][0];
            int y=points[i][1];
                //x轴逼近
                if(Math.abs(x-pre[0])<Math.abs(y-pre[1])){
                    int dis=(Math.abs(x-pre[0]));
                    res+=dis;
                    res+=(Math.abs(y-pre[1])-dis);
                    //y轴逼近
                }else {
                    int dis=(Math.abs(y-pre[1]));
                    res+=dis;
                    res+=(Math.abs(x-pre[0])-dis);
                }

            pre=points[i];
            }


        return res;
    }*/




   //nice solution 只需要找x和y轴差距大的那一个即可
    //可以这么想  先斜着走，直到某一个轴相等，然后横竖走，所以就是最大的差距即可
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; ++i) {
            int[] cur = points[i], prev = points[i - 1];
            ans += Math.max(Math.abs(cur[0] - prev[0]), Math.abs(cur[1] - prev[1]));
        }
        return ans;
    }
}
