package leetcode;

/**
 * Created by libin on 2019/1/1.
 */
public class leet88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     int i=m-1,j=n-1,k=m+n-1;
     while(i>=0&&j>=0) nums1[k--]= (nums1[i]>nums2[j]) ? nums1[i--] : nums2[j--];
     while(j>=0) nums1[k--]=nums2[j--];
    }
}
