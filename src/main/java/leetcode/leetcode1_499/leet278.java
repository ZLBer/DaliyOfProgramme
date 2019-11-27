package leetcode.leetcode1_499;

public class leet278 {
    public class Solution  {
        public int firstBadVersion(int n) {
         int left=0,right=n;
        int result=0;
         while (left<=right){
             int mid=left+(right-left)/2;
             if(isBadVersion(mid)){
                result=mid;
                right=mid-1;
             }else {
                 left=mid+1;
             }
         }

         return result;
        }
    }
   boolean isBadVersion(int version){
        return false;
   }
}
