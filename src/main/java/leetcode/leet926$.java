package leetcode;

/**
 * Created by libin on 2019/4/14.
 */
public class leet926$ {
    //将遍历的思想转变为DP
    public int minFlipsMonoIncr(String S) {
      int [] f0= new int[S.length()+1];
      int []  f1=new int[S.length()+1];
        for(int i=1,j=S.length()-1;i<=S.length()&&j>=0;i++,j--){
        f0[i]=f0[i-1]+(S.charAt(i-1)=='0'?0:1);
        f1[j]=f1[j+1]+(S.charAt(j)=='1'?0:1);
        }

int res=Integer.MAX_VALUE;
        for(int i=0;i<f0.length;i++){
     res=Math.min(res,f0[i]+f1[i]);
        }

return res;
     }
}
