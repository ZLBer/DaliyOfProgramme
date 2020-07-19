package leetcode;

public class leet1503 {
    public int getLastMoment(int n, int[] left, int[] right) {
       int maxLeft=0;
        for (int i : left) {
          maxLeft=Math.max(i,maxLeft);
        }
       int minRight=n;
        for (int i : right) {
          minRight=Math.min(i,minRight);
        } 
   return  Math.max(maxLeft-0,n-minRight);
    }
}
