package leetcode.leetcode1000_1499;

public class leet1400 {
    public boolean canConstruct(String s, int k) {
        if(k>s.length()) return false;
        int []counter=new int[26];
        for (char c : s.toCharArray()) {
             counter[c-'a']++;
        }

        int odd=0;
        for (int i = 0; i < counter.length; i++) {
            if(counter[i]%2==1) odd++;
        }
        if(odd>k) return false;

        return true;
    }


    // 一次变历就可以
 /*   public boolean canConstruct(String s, int k) {
        int odd = 0, n = s.length(), count[] = new int[26];
        for (int i = 0; i < n; ++i) {
            count[s.charAt(i) - 'a'] ^= 1;
            odd += count[s.charAt(i) - 'a'] > 0 ? 1 : -1;
        }
        return odd <= k && k <= n;
    }*/
}
