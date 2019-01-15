package leetcode;

/**
 * Created by libin on 2019/1/14.
 */
public class leet852 {
    //简单的遍历 O(n)
   /* public int peakIndexInMountainArray(int[] A) {
        for(int i=1;i<A.length;i++){
            if(A[i]>A[i-1]) continue;
            else return i-1;
        }
        return A[A.length-1];
    }*/

  //O(lg n)
    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (A[mid] < A[mid + 1]) l = mid;
            else if (A[mid - 1] > A[mid]) r = mid;
            else return mid;
        }
        return 0;
    }
}
