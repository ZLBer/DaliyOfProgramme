package leetcode.leetcode1_499;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/3/6.
 */
public class leet131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        dfs(result,new LinkedList<>(),s,0);
        return result;
    }

    void dfs(List<List<String>> result, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            result.add(new LinkedList<>(tempList));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tempList.add(s.substring(start, i + 1));
                dfs(result, tempList, s, i + 1);
                tempList.remove(tempList.size() - 1);
            }

        }

    }

    public boolean isPalindrome(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}
