package leetcode;

public class leet1007 {
      //mine 很繁琐的想法，一点不简洁
    /*   static public int minDominoRotations(int[] A, int[] B) {
        int seed=A[0];
        int countA=0;
        int countB=0;
        boolean flagA=true;
        boolean flagB=true;
        int common=0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]==seed&&B[i]==seed){
                common++;
                continue;
            }
            if(A[i]!=seed&&B[i]!=seed) {
                flagA=false;break;
            }
            if(A[i]==seed) countA++;
        }
        countA=Math.min(countA,A.length-common-countA);
        seed=B[0];
        common=0;
        for (int i = 0; i < B.length; i++) {
            if(A[i]==seed&&B[i]==seed){
                common++;
                continue;
            }
            if(A[i]!=seed&&B[i]!=seed) {
                flagB=false;break;
            }
            if(A[i]==seed) countB++;
        }
        countB=Math.min(countB,A.length-common-countB);

        if(flagA&&flagB){
            return Math.min(countA,countB);
        }
        else if(flagA)return countA;
        else if(flagB) return countB;
       else  return -1;
    }*/
   //简洁的做法  其实只需要A【0】或B【0】
   static public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == A[0] || B[i] == A[0]); ++i) {
            if (A[i] != A[0]) a++;
            if (B[i] != A[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == B[0] || B[i] == B[0]); ++i) {
            if (A[i] != B[0]) a++;
            if (B[i] != B[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        return -1;
    }
    public static void main(String[] args) {
   minDominoRotations(new int[]{2,1,2,4,2,2},new int[]{5,2,6,2,3,2});
    }
}
