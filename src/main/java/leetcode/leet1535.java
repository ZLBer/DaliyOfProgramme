package leetcode;

public class leet1535 {

    //简单比较即可
    public int getWinner(int[] arr, int k) {

       int count=0;
       int candidate=arr[0];
        for (int i = 1; i < arr.length; i++) {
          if(candidate>arr[i]) count++;
          else {
              candidate=arr[i];
              count=1;
          }
         if(count==k) return candidate;
        }
       return candidate;
    }
}
