package leetcode.leetcode1000_1499;

/**
 * Created by libin on 2019/4/8.
 */
public class leet1016 {
    //全部遍历
/*    public boolean queryString(String S, int N){
        for(int i=N;i>=1;i--){
            if(!S.contains(Integer.toBinaryString(i)))
                return false;
        }
        return true;
    }*/
    // 只遍历一半
//     The solution can be improve a half by checking from N to N/2.
//    The reason is simply for every i < N/2, the binary string of 2*i will contain binary string of i. Thus we don't need to check for i < N/2
    public boolean queryString(String S, int N) {
        for (int i = N; i > N / 2; --i)
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}
