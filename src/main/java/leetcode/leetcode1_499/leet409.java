package leetcode.leetcode1_499;

import java.util.Arrays;

/**
 * Created by libin on 2019/2/27.
 */
public class leet409 {

    //mine  排序后计算
    public int longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        int result = 0;
        int i=1,index=0;
        for (; i < ss.length; i++) {
            if (ss[i] == ss[index]) {
                continue;
            } else {
                result += ((i - index) / 2) * 2;
                index = i;
                System.out.println(result);
            }
        }
        result += ((i - index) / 2) * 2;


        if(result==s.length()) return result;
        else return result+1;
    }


    //用HashSet
   /* public int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            //两个匹配一对
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
    }*/



   //统计每个字母的个数
   /* public int longestPalindrome(String s) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (temp >= 97) lowercase[temp-'a']++;
            else uppercase[temp-'A']++;
        }
        for (int i = 0; i < 26; i++){
            res+=(lowercase[i]/2)*2;
            res+=(uppercase[i]/2)*2;
        }
        return res == s.length() ? res : res+1;

    }*/

}
