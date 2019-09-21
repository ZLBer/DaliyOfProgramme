package leetcode.leetcode500_999;

/**
 * Created by libin on 2018/12/31.
 */
public class leet888 {
   static public int[] fairCandySwap(int[] A, int[] B) {
        int countA=0,countB=0;
        for (int i=0;i<A.length;i++){
            countA+=A[i];
        }
        for (int i=0;i<B.length;i++){
            countB+=B[i];
        }
         int Dvalue=(countA-countB)/2;
        for (int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
            if(A[i]-B[j]==Dvalue) return new int[]{A[i],B[j]};
            }
        }

        return null;
    }

    public static void main(String[] args) {
       int a[]=fairCandySwap(new int[]{1,2,5},new int []{2,4});
       for (int c: a){
           System.out.println(c);
       }
    }
}
