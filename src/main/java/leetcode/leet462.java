package leetcode;

import java.util.Arrays;

public class leet462 {


    //mine 乱猜的方法居然对了  找中位数就好了
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int picker=0;
        if(nums.length%2==1){
          picker=nums[nums.length/2];
        }else {
           picker=(nums[nums.length/2-1]+nums[nums.length/2])/2;
        }
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res+=Math.abs(nums[i]-picker);
        }

        return res;
    }


    //还可以这样   感觉和中位数很像
/*    public int minMoves2(int[] nums) {
     Arrays.sort(nums);
     int i=0,j=nums.length-1;
    int res=0;
     while (i<j){
         res+=nums[j]-nums[i];
     }
     return res;
    }*/
//若是基于中位数  可以不用排序，之找出第k大的数就好了
/*    public int minMoves2(int[] A) {
        int sum = 0, median = quickselect(A, A.length/2+1, 0, A.length-1);
        for (int i=0;i<A.length;i++) sum += Math.abs(A[i] - median);
        return sum;
    }

     // 找第k大的数字
    public int quickselect(int[] A, int k, int start, int end) {
        int l = start, r = end, pivot = A[(l+r)/2];
        while (l<=r) {
            while (A[l] < pivot) l++;
            while (A[r] > pivot) r--;
            if (l>=r) break;
            swap(A, l++, r--);
        }
        //继续在左边找
        if (l-start+1 > k) return quickselect(A, k, start, l-1);
        //已经找到
        if (l-start+1 == k && l==r) return A[l];
        //去右边找
        return quickselect(A, k-r+start-1, r+1, end);
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }*/
}
