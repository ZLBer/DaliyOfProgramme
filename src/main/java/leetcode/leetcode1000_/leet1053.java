package leetcode.leetcode1000_;

public class leet1053 {
    public int[] prevPermOpt1(int[] A) {
   for(int i=A.length-2;i>=0;i--){
       int max=-1;
       int maxIndex=-1;
       for(int j=i+1;j<A.length;j++){
           if(A[i]>A[j]&&A[j]>max) {
               max=A[j];
               maxIndex=j;

           }
       }
       if(max!=-1){
           swap(A,i,maxIndex);
           return A;
       }
   }
   return A;
    }

    void swap(int []A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }

//更快的一种方法
   /* public int[] prevPermOpt1(int[] A) {
        //用left记录下降点 ，然后从end找一个比left小的点交换即可
        int n = A.length, left = n - 2, right = n - 1, tmp;
        while (left >= 0  && A[left] <= A[left + 1]) left--;
        if (left < 0) return A;
        while (A[left] <= A[right]) right--;
        while (A[right - 1] == A[right]) right--;
        tmp = A[left]; A[left] = A[right]; A[right] = tmp;
        return A;
    }*/
}
