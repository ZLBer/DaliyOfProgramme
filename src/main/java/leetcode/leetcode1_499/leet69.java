package leetcode.leetcode1_499;

public class leet69 {
 /*   public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }*/


 //二分搜索
  public int mySqrt(int x) {
        int left=1,right=x;
        while (left<=right){
 int mid=(left+right)/2;
 if(mid==x/mid){
     return mid;
 }
 else if(mid<x/mid){
      left=mid+1;
 }else {
     right=mid-1;
 }
        }
        return right;
    }
}
