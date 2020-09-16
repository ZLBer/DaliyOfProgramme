package leetcode.leetcode1000_1499;

public class leet1442 {
    public int countTriplets(int[] arr) {
        int res=0;
        for (int i = 0; i < arr.length; i++) {

            int a=arr[i];

            for(int j=i+1;j<arr.length;j++){
                int b=arr[j];
                if(a==b) res++;
                for(int k=j+1;k<arr.length;k++){

                    b^=arr[k];
                    if(a==b) res++;
                }
                a^=arr[j];
            }
        }
        return res;
    }
}
