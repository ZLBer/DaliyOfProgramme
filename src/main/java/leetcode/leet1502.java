package leetcode;

import java.util.Arrays;

public class leet1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int l=arr[1]-arr[0];
        for (int i = 2; i < arr.length; i++) {
           if(arr[i]-arr[i-1]!=l) return false;
        }
        return true;
    }
    public static void main(String[] args) {


    }
}
