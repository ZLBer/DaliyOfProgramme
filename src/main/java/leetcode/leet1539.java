package leetcode;

public class leet1539 {

    public int findKthPositive(int[] arr, int k) {
        int pre=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]-pre>1){
               k-=(arr[i]-pre-1);
            }
            if(k<=0){
               return arr[i]+k-1;
            }
            pre=arr[i];
        }

            return arr[arr.length-1]+k;

    }


    public static void main(String[] args) {
        System.out.println(1);
    }
}
