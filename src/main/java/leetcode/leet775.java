package leetcode;

public class leet775 {
    //     public boolean isIdealPermutation(int[] A) {

    //   int min=A.length;
//     for(int i=A.length-1;i>=2;i--){
//      min=Math.min(min,A[i]);
//     if(A[i-2]>min) return false;
//     }
//     return true;
//     }
    public boolean isIdealPermutation(int[] A) {
        for(int i=0;i<A.length;i++){
            if(Math.abs(A[i]-i)>1) return false;
        }
        return true;
    }
}
