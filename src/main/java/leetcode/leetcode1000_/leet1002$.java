package leetcode.leetcode1000_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by libin on 2019/3/5.
 */
public class leet1002$ {
  static  public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] cnt = new int[26];
            for (char c : str.toCharArray()) { ++cnt[c - 'a']; } // count each char's frequency in string str.
            for (int i = 0; i < 26; ++i) { count[i] = Math.min(cnt[i], count[i]); } // update minimum frequency.
        }
        for (int i = 0; i < 26; ++i) {
            while (count[i]-- > 0) { ans.add("" + (char)(i + 'a')); }
        }
        return ans;
    }

    public static void main(String[] args) {
        commonChars(new String[]{"bella","label","roller"});
    }
}
