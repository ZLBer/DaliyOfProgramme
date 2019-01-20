package leetcode;

import java.util.Arrays;

/**
 * Created by libin on 2019/1/20.
 */
public class leet977 {

    //双指针
/*
    public int[] sortedSquares(int[] A) {
        int []result=new int[A.length];
        if(A.length==1) return new int[]{A[0]*A[0]};
        int middle=A.length-1;
        for(int i=0;i<A.length;i++){
            if(A[i]>=0) {
                middle=i;
                break;
            }
        }
     int i=middle-1;
        int j=middle+1;
        while(i>=0&&j<A.length){

        }

    }
*/



    //直接法
        public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++){
            A[i]*=A[i];
        }
        Arrays.sort(A);
        return A;
            }
}
