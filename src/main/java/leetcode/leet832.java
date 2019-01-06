package leetcode;

/**
 * Created by libin on 2018/12/31.
 */
public class leet832 {
  static   public int[][] flipAndInvertImage(int[][] A) {
          for(int i=0;i<A.length;i++){
              int low=0;
              int high=A[0].length-1;
              while(low<=high){
                  int temp;
                  if(A[i][low]==1)
                      temp=0;
                  else  temp=1;
                 if (A[i][high]==1)
                     A[i][low]=0;
                 else   A[i][low]=1;
                 A[i][high]=temp;
                 low++;
                 high--;
              }
          }
          return A;
    }


//   大佬的算法，相同就异或，不同就不变
//    public int[][] flipAndInvertImage(int[][] A) {
//        int n = A.length;
//        for (int[] row : A)
//            for (int i = 0; i * 2 < n; i++)
//                if (row[i] == row[n - i - 1])
//                    row[i] = row[n - i - 1] ^= 1;
//        return A;
//    }
    public static void main(String[] args) {
       int a[][]=flipAndInvertImage(new int [][]{
                {1,1,0}
        });
       for (int i[]:a){
           for(int c: i){
               System.out.println(c);
           }
       }
    }
}
