package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leet962 {
    //dp超时了 O(n2)
/*    public int maxWidthRamp(int[] A) {
    int []dp=new int[A.length];
    int max=0;
        for (int i = 0; i < A.length; i++) {
             for(int j=i-1;j>=0;j--){
               if(A[i]>=A[j]&&dp[i]<dp[j]+i-j){
                   dp[i]=dp[j]+i-j;
               }
             }
        }
       for(int d:dp){
           max=Math.max(max,d);
       }
        return max;
    }*/

   //构造一个递减序列，然后依次查找  o（nlgn）
/*    public int maxWidthRamp(int[] A) {
        List<Integer> s = new ArrayList<>();
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            if (s.size() == 0 || A[i] < A[s.get(s.size() - 1)]) {
                s.add(i);
            } else {
                int left = 0, right = s.size() - 1, mid = 0;
                while (left < right) {
                    mid = (left + right) / 2;
                    if (A[s.get(mid)] > A[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                res = Math.max(res, i - s.get(left));
            }
        }
        return res;
    }*/
//用stack来做
    //先构造一个递减栈，然后从后面遍历A,使用过一次的数需要出栈，因为后面一点比前面的幅度要大 O(n)
    public int maxWidthRamp(int[] A) {
        Stack<Integer> s = new Stack<>();
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i)
            if (s.empty() || A[s.peek()] > A[i])
                s.add(i);
        for (int i = n - 1; i > res; --i)
            while (!s.empty() && A[s.peek()] <= A[i])
                res = Math.max(res, i - s.pop());
        return res;
    }
}
