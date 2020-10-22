package leetcode;

public class leet1588 {
    ///o(n3)
/*    public int sumOddLengthSubarrays(int[] arr) {

        int res=0;
        for (int i = 0; i < arr.length; i++) {

            for(int j=1;j<=arr.length;j+=2){
                if(i+j>arr.length) continue;
                int temp=0;
                for(int begin=i;begin<i+j;begin++){
                  temp+=arr[begin];
              }
                System.out.println(temp);
              res+=temp;
           }
        }
        return res;
    }*/

    //O(n) 非暴力
    public int sumOddLengthSubarrays(int[] arr) {
      int res=0;
        for (int i = 0; i < arr.length; i++) {
            int left=i+1,right=arr.length-i;
           int left_odd=(left+1)/2,left_even=(left)/2;
           int right_odd=(right+1)/2,right_even=(right)/2;
           res+=arr[i]*((left_odd*right_odd)+(left_even*right_even));
        }
        return res;
    }

}
