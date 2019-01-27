package leetcode;

/**
 * Created by libin on 2019/1/13.
 */
public class leet974$ {
    //超时
  /* static public int subarraysDivByK(int[] A, int K) {
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
*/
  
  /*  
举例：Input: A = [4,5,0,-2,-3,1], K = 5
prefixSum = [0, 4, 9, 9, 7, 4, 5] mod = [0, 4, 4, 4, 2, 4, 0] (首位0是占位作用)
sub[0, 0] = prefixSum[1] - prefixSum[0];
mod为4的索引有4个，[1,2,3,5]，有6（1 + 2 + 3）subArray满足题目要求sub[1,2] sub[1,3] sub[1,5] sub[2,3] sub[2,4] sub[3,5]

   */  
    public int subarraysDivByK(int[] A, int K) {
        int N = A.length;
        int[] P = new int[N+1];
        //计算前N项和
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        int[] count = new int[K];
        //计算余数
        for (int x: P)
            //防止负数出现
            count[(x % K + K) % K]++;

        int ans = 0;
        //统计个数
        for (int v: count)
            ans += v * (v - 1) / 2;
        return ans;
    }


    public static void main(String[] args) {
    //    subarraysDivByK(new int[]{4,5,0,-2,-3,1},5);\
                                   //4,4,4,2,4,0
        System.out.println(-5%5);
    }
}
