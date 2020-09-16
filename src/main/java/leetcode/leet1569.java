package leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class leet1569 {
  static   public int numOfWays(int[] nums) {

    List<Integer> list=new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
      return (int)dfs(list,0,nums.length-1)-1;
    }
static int mod=1000000007;
   static long dfs(List<Integer> list,int start,int end){
       if(list.size()<=2) return 1;

       int root=list.get(start);
       List<Integer> less=new ArrayList<>();
       List<Integer> greater=new ArrayList<>();
       for(int i=start+1;i<=end;i++){
           int ans=list.get(i);
         if(ans<root){
             less.add(ans);
         } else {
            greater.add(ans);
         }
       }
      long res=(combination(Math.min(greater.size(),less.size()),list.size()-1)*((dfs(less, 0,less.size()-1)*dfs(greater,0,greater.size()-1))%mod))%mod;
return res;
    }

    //分开算没法取模了
/* static    long combination(int m,int n){
        long res= (factorial(n)/(factorial(n-m)*factorial(m)));

    // System.out.println(m+" "+n+" "+res);
        return res;
    }

  static   long factorial(int n){
        if(n==0)return 1;//0的阶乘是1
        long res=1;
        for (int i = 1; i <= n; i++) {
         res*=i;
        res%=mod;
        }
    //  System.out.println(res);
        return res;
    }*/


//这种求组合数的方式是不对的  溢出
/*    static    long combination(int m,int n) {
        long res=1;
        int a=1,b=n;
        for(int i=1;i<=m;i++){
            res*=b;
            res/=a;

            b--;
            a++;
        }
        return res%mod;
    }*/


    //只能该用BigInteger
 static long combination(int small,int great ) {
        int a = 1;
        int b = great;
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 0; i < small; i++) {
            res = res.multiply(BigInteger.valueOf(b)).divide(BigInteger.valueOf(a));
            b--;
            a++;
        }
        res = res.remainder(BigInteger.valueOf(1000000007));
        return res.longValue();
    }








  //注意下面求组合数的方法  其实是杨辉三角 绝了 杨辉三角居然可以快速求组合数
 /*   int N = 1010, mod = (int) 1e9 + 7;
    int[][] C = new int[N][N];
    public int numOfWays(int[] nums) {
        int n = nums.length;
        init(n);
        List<Integer> list = new ArrayList();
        for(int i = 0; i < n; i++) list.add(nums[i]);
        return f(list) - 1;
    }

    public int f(List<Integer> list){
        if(list.isEmpty()) return 1;
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        int n = list.size();
        int r = list.get(0);
        for(int i = 1; i < n; i++){
            if(list.get(i) <= r) left.add(list.get(i));
            else right.add(list.get(i));
        }
        return (int)((long)C[n - 1][left.size()] * f(left) % mod * f(right) % mod);
    }

    //求组合数， 因为题目数据范围比较小
    public void init(int n){
        for(int a = 0; a <= n; a++){
            for(int b = 0; b <= a; b++){
                if(b == 0) C[a][b] = 1;
                else{
                    C[a][b] = (C[a - 1][b] + C[a - 1][b - 1]) % mod;
                }
            }
        }
    }
*/

    public static void main(String[] args) {
        System.out.println(combination(5,35));
    }
}
