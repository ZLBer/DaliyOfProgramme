package leetcode;

public class LCP22 {
    //mine   写的过于复杂了
 /* static   public int paintingPlan(int n, int k) {
     if(k==n*n) return 1;
      int res=0;

        for(int row=0;row<=k/n;row++){
       int count=row*n;//
       //求有多少种列
       int remaind=k-count;
       int colcount=n-row;//一列有多少个
        if(remaind==0) {
            res+=help(row,n);
            continue;
        }
       if(remaind%colcount!=0||remaind/colcount>n) continue; //不符合条件

       int col=remaind/colcount;


       //全排列
       res+=help(row,n)*help(col,n);
       }
       return res;
    }

 static   int help(int n,int  m){
        if(n==0) return 1;
     int up=1; int down=1;
        for(int i=1;i<=n;i++){
           down*=i;
        }
      for(int i=m;i>m-n;i--){
         up*=i;
      }
       System.out.println(n+" "+m+"  "+up+" "+down);
     return up/down;
   }*/




 //找到规律后就是这么简单
    public int paintingPlan(int n, int k) {

        if(k==n*n) return 1;

        int ans = 0;
        for(int a=0; a<=n; a++) {
            for(int b=0; b<=n; b++) {
                int sum = a*n + b*n - a*b;
                if(sum==k) {
                    int x = combination(n, a);
                    int y = combination(n, b);
                    ans += x*y;
                }
            }
        }

        return ans;
    }

    int combination(int n, int m) {
        int ans = 1;
        for (int i = n; i > m; i--) ans *= i;
        for (int i = n - m; i > 0; i--) ans /= i;
        return ans;
    }

    public static void main(String[] args) {
     //   paintingPlan(3,7);
    }
}
