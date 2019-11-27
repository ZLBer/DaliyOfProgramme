package leetcode.leetcode1000_;

public class leet1109 {
    //mine
/*    public int[] corpFlightBookings(int[][] bookings, int n) {
      int[]result=new int[n];
      for(int i=0;i<bookings.length;i++){
        int []booking=bookings[i];
        int begin=booking[0],end=booking[1];
        while (end>=begin){
            result[end-1]+=booking[2];
            end--;
        }
      }
      return result;
    }*/


    //超级优秀的解法
    public int[] corpFlightBookings(int[][] bookings, int n) {
       int []result=new  int[n];
        for(int []booking:bookings){
          result[booking[0]-1]+=booking[2];
          if(booking[1]<n) result[booking[1]]-=booking[2];
        }
        for(int i=1;i<n;i++){
            result[i]+=result[i-1];
        }
        return result;
    }
}
