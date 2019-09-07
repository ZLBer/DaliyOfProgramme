package leetcode;

import java.util.Arrays;

public class leet14 {
    //mine
/*    public String longestCommonPrefix(String[] strs) {
  if(strs.length==0) return "";
int minlegth=Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
              minlegth=Math.min(minlegth,strs[i].length());
        }
        
        int count=0;

        while (count<minlegth) {
            char c = strs[0].charAt(count);
            boolean flag = true;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(count) != c) {
                    flag = false;
                    break;
                }
            }
            if (flag == false) break;
            count++;
        }

        return strs[0].substring(0,count+1);
    }*/



//先排序  只看最长和最短的
  /*  public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";

        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last  = strs[strs.length - 1].toCharArray();

        int i = 0, len = Math.min(first.length, last.length);
        while (i < len && first[i] == last[i]) i++;
        return strs[0].substring(0, i);
    }*/


    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(!strs[i].startsWith(pre) )
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}
