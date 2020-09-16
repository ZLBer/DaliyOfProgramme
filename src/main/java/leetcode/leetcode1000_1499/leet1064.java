package leetcode.leetcode1000_1499;

public class leet1064 {
    //O(N)
 /*   public int fixedPoint(int[] A) {
        for (int i = 0; i < A.length; i++) {
             if(i==A[i]) return i;
        }
        return -1;
    }*/
    //二分搜索 lgN
    public int fixedPoint(int[] A) {
    int left=0,right=A.length-1;
    int mid=0;
    while (left<=right){
        mid=(left+right)/2;
        if(A[mid]==mid) return mid;
        else if(A[mid]>mid){
            right=mid-1;
        }
        else {
            left=mid+1;
        }
    }
    return -1;
       }
}
