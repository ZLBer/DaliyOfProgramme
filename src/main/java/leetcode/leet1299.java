package leetcode;

public class leet1299 {
/*    public int[] replaceElements(int[] arr) {
      int maxSum=arr[arr.length-1];
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp=arr[i];
            arr[i]=maxSum;
            maxSum=Math.maxSum(maxSum,temp);
        }
        arr[arr.length-1]=-1;
        return arr;
    }*/
    //可以都合并到一个循环里
    public int[] replaceElements(int[] arr) {
        int max=-1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp=arr[i];
            arr[i]=max;
            max=Math.max(max,temp);
        }
        return arr;
    }
}
