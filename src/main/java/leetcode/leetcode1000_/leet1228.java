package leetcode.leetcode1000_;

public class leet1228 {

    public int missingNumber(int[] arr) {
        int sub=(arr[arr.length-1]-arr[0])/arr.length;
        int next=arr[0]+sub ;
        int res=0;
        for (int i = 1; i < arr.length; i++) {
             if(arr[i]==next){
               next+=sub;
             }else {
              res=next;
              break;
             }
        }
        return res;
    }
}
