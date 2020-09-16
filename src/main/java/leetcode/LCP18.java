package leetcode;

import java.util.Arrays;

public class LCP18 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
   long res=0;

   //Arrays.sort(staple);
    Arrays.sort(drinks);
   int mod=1000000007;
        for (int i = 0; i < staple.length; i++) {
                int target=x-staple[i];
                int left=0,right=drinks.length;
                while (left<right){
                 int mid=(left+right)/2;
                 if(drinks[mid]<=target){
                    left=mid+1;
                 }else {
                     right=mid;
                 }
                }
                System.out.println(left);
             res+=left;
              res%=mod;

        }

        return (int)res;
    }


    public static void main(String[] args) {

    }
}
