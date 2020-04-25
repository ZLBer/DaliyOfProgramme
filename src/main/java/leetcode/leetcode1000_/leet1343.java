package leetcode.leetcode1000_;

public class leet1343 {
    //mine 滑动窗口  代码懒的一批
/*    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int count=0;
        int sum=0;
        int res=0;
        int start=0;
        for (int i = 0; i < arr.length; i++) {
            if(count==k){
              if(sum/k>=threshold) res++;
              sum-=arr[start++];
              sum+=arr[i];
            }else {
                sum+=arr[i];
                count++;
            }
        }
        if(sum/k>=threshold) res++;
        return res;
    }*/
  //重写一遍  争取放到一个for里
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int count=0;
        int sum=0;
        int res=0;
        int start=0;
        for (int i = 0; i < arr.length; i++) {
          sum+=arr[i];
          if(i-start==k-1){
              if(sum/k>=threshold) res++;
              sum-=arr[start++];
           }
        }
        return res;
    }

   //还可以用前缀和来做
/*    public int numOfSubarrays(int[] a, int k, int threshold) {
        int n = a.length, count = 0;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i)
            prefixSum[i + 1] = prefixSum[i] + a[i];
        for (int i = 0; i + k <= n; ++i)
            if (prefixSum[i + k] - prefixSum[i] >= k * threshold)
                ++count;
        return count;
    }*/
}
