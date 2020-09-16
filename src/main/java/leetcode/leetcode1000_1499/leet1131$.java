package leetcode.leetcode1000_1499;

public class leet1131$ {

    //解释  https://leetcode.com/problems/maximum-of-absolute-value-expression/discuss/340070/topic
    public int maxAbsValExpr(int[] arr1, int[] arr2) {

     Integer []ans=new Integer[arr1.length];
int res=0;
     for(int i=-1;i<=1;i+=2){
         for(int j=-1;j<=1;j+=2){
             for(int k=0;k<arr1.length;k++){
                 ans[k]=arr1[k]*i+arr2[k]*j+k;
             }
//           int max=  Collections.max(Arrays.asList(ans));
//             int min=Collections.min(Arrays.asList(ans));


             //这样快一点
               int max= Integer.MIN_VALUE;
               int min=Integer.MAX_VALUE;
               for(int a:ans){
                   max=Math.max(max,a);
                   min=Math.min(min,a);
               }
             res=Math.max(res,max-min);
         }
     }
     return res;
    }
}
