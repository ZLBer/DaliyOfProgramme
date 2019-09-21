package leetcode.leetcode500_999;

/**
 * Created by libin on 2018/12/31.
 */
public class leet905 {
  static   public int[] sortArrayByParity(int[] A) {
        int low=0;
        int high=A.length-1;
        while (low<high){
            while (low<A.length-1&&A[low]%2==0) low++;
            while(high>0&&A[high]%2==1) high--;
            if(low<=high) {
                int temp = A[low];
                A[low] = A[high];
                A[high] = temp;
                low++;
                high--;
            }
        }
        return A;
    }

    public static void main(String[] args) {
int []q=sortArrayByParity(new int []{0,1});
for(int a:q){
    System.out.println(a);
}
    }
}
