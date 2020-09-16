package leetcode.leetcode1_499;

import java.util.HashMap;
import java.util.Map;

public class leet378 {

    //搞半天搞迷糊了  不太对的样子
  /*static   public int kthSmallest(int[][] matrix, int k) {
        int l=0,r=matrix.length-1;
        int all=matrix.length*matrix.length;
        while(l<r){
            int mid=(l+r)/2;
            int test=(matrix.length-mid)*(matrix.length-mid);
            if(k<=test){
                r=mid-1;
            } else{
                k-=test;
               l=mid;
                all=(matrix.length-l)*(matrix.length-l);
            }

        }
        System.out.println(l);
      System.out.println(k);
     //确定在l行l列交界处
     if(k==1 ) return matrix[l][l];
     k--;
      int i=l+1,j=l+1;
      while (k>0&&i<matrix.length&&j<matrix.length){
     if(matrix[i][l]<=matrix[l][j]){
        i++;
     }else {
         j++;
     }
     k--;
      }

       if(k>0&&i<matrix.length){
          return matrix[i+k-1][l];
       }
      if(k>0&&j<matrix.length){
          return matrix[l][j+k-1];
      }
return Math.min(matrix[i][l],matrix[l][j]);
    }*/


    //这种二分是真厉害啊
    public int kthSmallest(int[][] matrix, int k) {
       int l=matrix[0][0];
       int n=matrix.length;
       int r=matrix[n-1][n-1];
       while (l<r){
        int mid=(l+r)/2;
       if(check(matrix,k,mid)){
           r=mid;
       }else {
           l=mid+1;
       }
       }
       return l;
    }

    boolean check(int [][]matrix,int k,int num){
      int i=matrix.length-1,j=0;
     int count=0;
      while (i>=0&&j<matrix.length){
        if(matrix[i][j]<=num){
           j++;
           count+=i+1;
        }else {
           i--;
        }
     }
      return count>=k;
    }

    public int[] masterMind(String solution, String guess) {
        int []res=new int[]{0,0};
        Map<Character,Integer> map=new HashMap<>();
        map.put('R',0);
        map.put('Y',0);
        map.put('G',0);
        map.put('B',0);
        boolean [] is=new boolean[guess.length()];
        for(int i=0;i<solution.length();i++){
            char a= solution.charAt(i),b=guess.charAt(i);
            if(a==b) {
                res[0]++;
                is[i]=true;
            }
            else{
                map.put(a,map.get(a)+1);
            }
        }
        for(int i=0;i<guess.length();i++){
            if(is[i])continue;
            char a=guess.charAt(i);
            int test=map.get(a);
            if(test==0) continue;
            res[1]++;
            map.put(a,test-1);
        }
        return res;
    }

}
