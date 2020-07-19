package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet842 {
    //混一个
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        helper(S, ans, 0);
        return ans;
    }

    public boolean helper(String s, List<Integer> ans, int idx) {
        if (idx == s.length() && ans.size() >= 3) {//搜索完毕
            return true;
        }
        for (int i=idx; i<s.length(); i++) {
            if (s.charAt(idx) == '0' && i > idx) { //有先导0
                break;
            }
            long num = Long.parseLong(s.substring(idx, i+1));
            if (num > Integer.MAX_VALUE) {//越界
                break;
            }
            int size = ans.size();
            // early termination
            if (size >= 2 && num > ans.get(size-1)+ans.get(size-2)) { //剪枝
                break;
            }
            if (size <= 1 || num == ans.get(size-1)+ans.get(size-2)) {
                ans.add((int)num);
                // branch pruning. if one branch has found fib seq, return true to upper call
                if (helper(s, ans, i+1)) {
                    return true;
                }
                ans.remove(ans.size()-1); //回溯
            }
        }
        return false;
    }
}
