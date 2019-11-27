package leetcode.leetcode1000_;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by libin on 2019/3/19.
 */
public class leet1012$ {
    //依次遍历 Time Limit Exceeded
//    public int numDupDigitsAtMostN(int N) {
//        int result=0;
//        Map<Integer,Integer> maps=new HashMap<>();
//        for(int i=0;i<=N;i++){
//       int a=i;
//       while (a>0){
//           if(!maps.containsKey(a%10))
//                 maps.put(a%10,1);
//           else{
//               result++;
//               break;
//           }
//           a=a/10;
//       }
//       maps.clear();
//        }
//
//
//
//        return result;
//    }

    public int numDupDigitsAtMostN(int N) {
        // 将每一位的数字放进数组
        ArrayList<Integer> L = new ArrayList<Integer>();
        for (int x = N + 1; x > 0; x /= 10)
            L.add(0, x % 10);

        // 计算位数小于N的不重复数字
        int res = 0, n = L.size();
        for (int i = 1; i < n; ++i)
            res += 9 * A(9, i - 1);

        // 计算有相同前缀的数字
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            //如果是第一个数字，则不可以从0开始
            for (int j = i > 0 ? 0 : 1; j < L.get(i); ++j)
                if (!seen.contains(j))
                    res += A(9 - i, n - i - 1);
            if (seen.contains(L.get(i))) break;
            seen.add(L.get(i));
        }
        return N - res;
    }

  //指定位数阶乘
   static public int A(int m, int n) {
        return n == 0 ? 1 : A(m, n - 1) * (m - n + 1);
    }

    public static void main(String[] args) {
        System.out.println(A(9,0));
    }
}
