package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leet870 {
  static   public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
       // Arrays.sort(B);
        int [][]BB=new int[B.length][2];
        for (int i = 0; i < B.length; i++) {
            BB[i][0]=B[i];
            BB[i][1]=i;
        }
        Arrays.sort(BB,(a,b)->a[0]-b[0]);
        int index=0;
        int i=0;
        for (; index<A.length&&i < B.length; i++) {
           while (index<A.length&&A[index]<=BB[i][0])index++;
           if(index<A.length){
              B[BB[i][1]]=A[index];
               A[index]=-1;
               index++;
           }
        }


       Queue<Integer> queue=new LinkedList<>();
        for (int j = 0; j < A.length; j++) {
            if(A[j]<0) continue;
            queue.add(A[j]);
        }
       i=B.length-1;
    while (!queue.isEmpty()){
        B[BB[i][1]]=queue.poll();
        i--;
    }

       return B;
    }

    public static void main(String[] args) {
        advantageCount(new int[]{5621,1743,5532,3549,9581},new int[]{913,9787,4121,5039,1481});
    }
}
