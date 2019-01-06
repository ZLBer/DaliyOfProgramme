package leetcode;

/**
 * Created by libin on 2018/12/29.
 */
public class leet941 {
   static public boolean validMountainArray(int[] A) {
       int i = 0;
       int up=0,dowm=0;
       for (; i < A.length - 1; ) {
           if (A[i] < A[i + 1]) i++;
           else break;
           up=1;
         //  System.out.println(i);
       }
    //   System.out.println(i);
       for (; i < A.length - 1; ) {
           if (A[i + 1] < A[i]) i++;
           else  break;
           dowm=1;
       }

       if (i == A.length - 1&&up==1&&dowm==1) return true;
       else return false;

   }

    public static void main(String[] args) {
        System.out.println( validMountainArray(new int[]{1,2,2}));
    }
}
