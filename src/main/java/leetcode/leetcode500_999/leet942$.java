package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/14.
 */
public class leet942$
{


    public int[] diStringMatch(String S) {
        int []result=new int[S.length()+1];
        int high=S.length();
        int low=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='I')
                result[i]=low++;
            else result[i]=high--;
        }
        result[S.length()]=low;
        return result;

    }
   /* public int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }*/
}
