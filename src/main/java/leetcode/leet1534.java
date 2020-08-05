package leetcode;

public class leet1534 {
/*    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res=0;
        for (int i = 0; i < arr.length; i++) {
           for(int j=i+1;j<arr.length;j++){
               for(int k=j+1;j<arr.length;k++){
                  if(Math.abs(arr[i]-arr[j])<=a&&Math.abs(arr[j]-arr[k])<=b&&Math.abs(arr[i]-arr[k])<=c){
                      res++;
                  }
               }
           }
        }
        return  res;
    }*/


    //可以提前剪枝
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        for(int i = 0; i < n -2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                if(Math.abs(arr[i] - arr[j]) <= a) { // check if satisfy then loop for k
                    for(int k = j + 1; k < n; k++) {
                        if(Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c)
                            count++;
                    }
                }
            }
        }

        return count;
    }
}
