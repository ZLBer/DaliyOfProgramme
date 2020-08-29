package leetcode;

public class leet1551 {
    public int minOperations(int n) {
     int sum=0;
        if(n%2==1){
        for(int i=0;i<n;i+=2){
          sum+=i;
        }
     }else {
            for (int i = 1; i < n; i += 2) {
                sum += i;
            }
        }
      return  sum;
    }
}
