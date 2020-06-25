package leetcode._jianzhioffer;

public class p6 {
/*
  static   Map<Long,Double> map=new HashMap<>();
  static   public double myPow(double x, int n) {
        if(n==0) return 1;
        double res=helper(x,Math.abs((long)n));
      System.out.println(res);
    return n<0?1/res:res;
    }

  static   double helper(double x,long n){
        if(n==1) return x;
       if(map.containsKey(n)) return map.get(n);
        double res= n%2==1?helper(x,n/2)*helper(x,n/2)*x:helper(x,n/2)*helper(x,n/2);
     map.put(n,res);
     return res;
    }*/

   //迭代
    public double myPow(double x, int n){
        long b=n;
     if(n<0){
        x=1/x;
        b=-b;
     }
    double res=1;
    while (b>0){
      if((b&1)==1)  res*=x;
      x*=x;
      b>>=1;
    }
    return res;
    }

    public static void main(String[] args) {
     //  System.out.println( myPow(2.0,-2147483648));
        System.out.println(Math.abs(-2147483648));
  }

}