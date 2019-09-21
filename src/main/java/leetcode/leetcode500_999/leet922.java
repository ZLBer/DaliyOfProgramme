package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/3.
 */
public class leet922 {
    public int[] sortArrayByParityII(int[] A) {
        int B[]=new int[A.length];
        int even=0;
        int odd=1;
 for (int i=0;i<A.length;i++){
      if(A[i]%2==0){
          B[even]=A[i];
          even+=2;
      }
      else {
          B[odd]=A[i];
          odd+=2;
      }
 }
return  B;
    }
    //用两个指针分别遍历偶位和奇位，符合则继续，不符合则停止，然后交换
//    public int[] sortArrayByParityII(int[] A) {
//        int i = 0, j = 1, n = A.length;
//        while (i < n && j < n) {
//            while (i < n && A[i] % 2 == 0) {
//                i += 2;
//            }
//            while (j < n && A[j] % 2 == 1) {
//                j += 2;
//            }
//            if (i < n && j < n) {
//                swap(A, i, j);
//            }
//        }
//        return A;
//    }
//    private void swap(int[] A, int i, int j) {
//        int temp = A[i];
//        A[i] = A[j];
//        A[j] = temp;
//    }
}
