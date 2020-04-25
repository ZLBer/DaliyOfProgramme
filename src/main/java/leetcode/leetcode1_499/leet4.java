package leetcode.leetcode1_499;

public class leet4 {

    //mine  纯粹是用if搭起来的
/*    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==1&&nums2.length==1)
            return (nums1[0]+nums2[0])/2.0;
     int l=nums1.length+nums2.length;
     int media=0;
     if(l%2==1){
            media=l/2;
     }else {
         media=l/2-1;
     }
     int index=0;
     int i=0,j=0;
     while (index<media){
        index++;
         if(i<nums1.length&&j<nums2.length){
             if(nums1[i]<=nums2[j]){
                 i++;
             }
             else j++;
         }
         else if(i<nums1.length){
             i++;
         }
         else j++;
     }
      //  System.out.println(i+"  "+j);
     float result=0;

        if(l%2==1){
           if(i>=nums1.length) {
               result = nums2[j];
               return result;
           }
           if(j>=nums2.length){
               result=nums1[i];
               return result;
           }
           return Math.min(nums1[i],nums2[j]);
        }else {
            if(i>=nums1.length) {
            result=((float)(nums2[j]+nums2[j+1]))/2;
           return result;
            }
            if(j>=nums2.length){
                result=((float)(nums1[i]+nums1[i+1]))/2;
                return result;
            }

            if(i+1>=nums1.length){
               return  (nums1[i]+nums2[j]+nums2[j+1]-Math.max( nums1[i],Math.max(nums2[j],nums2[j+1])))/2.0;
            }
            if(j+1>=nums2.length){
                return  (nums1[i]+nums2[j]+nums1[i+1]-Math.max( nums1[i],Math.max(nums2[j],nums1[i+1])))/2.0;
            }
           return  helper(nums1[i],nums1[i+1],nums2[j],nums2[j+1])/2.0;
        }

    }
    //返回四个数最小的两个的和
    int helper(int a,int b,int c,int d){
        int []arr=new int[4];
        arr[0]=a;
        arr[1]=b;
        arr[2]=c;
        arr[3]=d;
        Arrays.sort(arr);
        return arr[0]+arr[1];
    }*/



//换成两个media位置   省了很多判断
/*
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l=nums1.length+nums2.length;
        int media1=0,media2;
        if(l%2==1){
            media1=media2=l/2;
        }else {
            media1=l/2-1;
            media2=l/2;
        }
        //System.out.println(media1+"   "+media2);
        int index=0;
        int i=0,j=0;
        int sum=0;
        while (index<=media2){
            if(i<nums1.length&&j<nums2.length){
                if(nums1[i]<=nums2[j]){

                    if(index==media1) sum+=nums1[i];
                    if(index==media2) sum+=nums1[i];
                    i++;
                }
                else {

                    if(index==media1) sum+=nums2[j];
                    if(index==media2) sum+=nums2[j];
                    j++;
                }
            }
            else if(i<nums1.length){

                if(index==media1) sum+=nums1[i];
                if(index==media2) sum+=nums1[i];
                i++;
            }
            else {

                if(index==media1) sum+=nums2[j];
                if(index==media2) sum+=nums2[j];
                j++;
            }

            index++;
        }
      return sum/2.0;
    }
*/


  // 二分法  太强了..
    //https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn)))-solution-with-explanation
/*    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;


        //保证n>m
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
         //i表示A截断的地方，j表示B截断的地方  需要保证 i + j == m - i + n - j （ 即让左半边元素数量等于与右半边）
        int i = 0, j = 0, imin = 0, imax = m, half = (m + n + 1) / 2;
        double maxLeft = 0, minRight = 0;
        //二分查找
        while(imin <= imax){
            //从中间截断
            i = (imin + imax) / 2;
            //满足左半边元素数量等于与右半边
            j = half - i;
            // 意味着 A[i] 太小， 那么我们必须调整 i 以使 `B[j-1] <= A[i]` 仍然成立。
            if(j > 0 && i < m && nums2[j - 1] > nums1[i]){
                imin = i + 1;
          // 意味着 A[i] 太大， 那么我们必须调整 i 以使 `A[i-1] <= B[j]` 仍然成立。
            }else if(i > 0 && j < n && nums1[i - 1] > nums2[j]){
                imax = i - 1;

            //符合 B[j-1] <= A[i]   A[i-1] <= B[j]
            }else{
                //i=0表示中位数在B中取
                if(i == 0){
                    maxLeft = (double)nums2[j - 1];
                    //j=0表示中位数在A中取
                }else if(j == 0){
                    maxLeft = (double)nums1[i - 1];
                }else{
                    maxLeft = (double)Math.max(nums1[i - 1], nums2[j - 1]);
                }
                break;
            }
        }
        //奇数的情况
        if((m + n) % 2 == 1){
            return maxLeft;
        }

        //偶数
        if(i == m){
            //未在A中取
            minRight = (double)nums2[j];
        }else if(j == n){
            //未在B中取
            minRight = (double)nums1[i];
        }else{
            //返回最小
            minRight = (double)Math.min(nums1[i], nums2[j]);
        }

        return (maxLeft + minRight) / 2.0;
    }*/



    //2020/4/14
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
   int m=nums1.length;
   int n=nums2.length;
   int left=(m+n+1)/2,right=(m+n+2)/2;//第k个数 从1开始
     return (helper(nums1,0,nums2,0,left)+helper(nums1,0,nums2,0,right))*0.5;
    }

    int helper(int []nums1,int start1,int []nums2,int start2,int k){
        if(start1>=nums1.length) return nums2[start2+k-1];
        if(start2>=nums2.length) return nums1[start1+k-1];

        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }

        int median1=(start1+k/2-1<nums1.length)?nums1[start1+k/2-1]:Integer.MAX_VALUE;
        int median2=(start2+k/2-1<nums2.length)?nums2[start2+k/2-1]:Integer.MAX_VALUE;

        if(median1<median2){ //nums1的前k/2个都用不到了
            return helper(nums1,start1+k/2,nums2,start2,k-k/2);
        }else {
            return helper(nums1,start1,nums2,start2+k/2,k-k/2);
        }
    }

}
