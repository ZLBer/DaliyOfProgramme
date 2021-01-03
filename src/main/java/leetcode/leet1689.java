package leetcode;

public class leet1689 {
    public int minPartitions(String n) {
       int max=0;
        for (int i = 0; i < n.length(); i++) {
            char c=n.charAt(i);
              max=Math.max(c-'0',max);
        }

        return max;
    }


}
