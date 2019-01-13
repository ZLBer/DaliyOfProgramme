package leetcode;

/**
 * Created by libin on 2019/1/13.
 */
public class leet974 {
    //超时
   static public int subarraysDivByK(int[] A, int K) {
        int count=0;
        for(int i=0;i<A.length;i++){
            int sum=0;
            for(int j=i;j<A.length;j++){
                 sum+=A[j];
                 if(sum%K==0) count++;
            }
        }
        return count;
    }




    public static void main(String[] args) {
    //    subarraysDivByK(new int[]{4,5,0,-2,-3,1},5);\
                                   //4,4,4,2,4,0
        System.out.println(-5%5);
    }
}
