package leetcode.leetcode1000_1499;

public class leet1310 {
    //mine contest
    /*   public int[] xorQueries(int[] arr, int[][] queries) {
        int []res=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int temp=arr[queries[i][0]];
            for (int j = queries[i][0]+1; j <=queries[i][1]; j++) {
             temp^=arr[j];
            }
            res[i]=temp;
        }
        return res;
    }*/

      //强 保存前缀  同一个数字异或自己就没了
    public int[] xorQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length], q;
        for (int i = 1; i < A.length; ++i)
            A[i] ^= A[i - 1];
        for (int i = 0; i < queries.length; ++i) {
            q = queries[i];
            res[i] = q[0] > 0 ? A[q[0] - 1] ^ A[q[1]] : A[q[1]];
        }
        return res;
    }

}
