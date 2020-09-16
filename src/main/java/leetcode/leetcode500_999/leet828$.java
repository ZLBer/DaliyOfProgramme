package leetcode.leetcode500_999;

import java.util.*;

public class leet828$ {


    //纯暴力  超时
//    public int uniqueLetterString(String s) {
//
//       long res=0;
//
//       int mod=100_000_0007;
//        for (int i = 0; i < s.length(); i++) {
//            int[] count=new int[26];
//            int co=0;
//          for(int j=i;j<s.length();j++){
//             int index=s.charAt(j)-'A';
//             count[index]++;
//            if(count[index]==2){
//                co--;
//            }else if(count[index]==1){
//                co++;
//            }
//            res+=co;
//            res%=mod;
//          }
//        }
//        return (int)res;
//    }



    //直接换种思考的方式  太强了
/*    public int uniqueLetterString(String s) {
     int [][]index=new int[26][2];
        for (int i = 0; i < index.length; i++) {
            Arrays.fill(index[i],-1);
        }
       int res=0,N=s.length(),mod=100_000_0007;
        for (int i = 0; i < s.length(); i++) {
            int ind=s.charAt(i)-'A';
          res=(res+(i-index[ind][1])*(index[ind][1]-index[ind][0])%mod)%mod;
         index[ind]=new int[]{index[ind][1],i};//更新索引
        }
        for (int i = 0; i < index.length; i++) {
           res=(res+(N-index[i][1])*(index[i][1]-index[i][0])%mod)%mod;
        }
        return res;
    }*/

    //和上面的思路一样，可能更好理解的代码
    public int uniqueLetterString(String S) {
        Map<Character, List<Integer>> index = new HashMap();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            index.computeIfAbsent(c, x-> new ArrayList<Integer>()).add(i);
        }

        long ans = 0;
        for (List<Integer> A: index.values()) {
            for (int i = 0; i < A.size(); ++i) {
                long prev = i > 0 ? A.get(i-1) : -1;
                long next = i < A.size() - 1 ? A.get(i+1) : S.length();
                ans += (A.get(i) - prev) * (next - A.get(i));
            }
        }

        return (int) ans % 1_000_000_007;
    }

    //dp的思路
/*    public int uniqueLetterString(String S) {

        int res = 0;
        if (S == null || S.length() == 0)
            return res;
        int[] showLastPosition = new int[128];
        int[] contribution = new int[128];
        int cur = 0;
        for (int i = 0; i < S.length(); i++) {
            char x = S.charAt(i);
            cur -= contribution[x];
            contribution[x] = (i - (showLastPosition[x] - 1));
            cur += contribution[x];
            showLastPosition[x] = i + 1;
            res += cur;
        }
        return res;
    }*/
}
