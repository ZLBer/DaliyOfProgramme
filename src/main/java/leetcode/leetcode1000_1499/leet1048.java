package leetcode.leetcode1000_1499;

import java.util.Arrays;
import java.util.Comparator;

public class leet1048 {
    //mine DP
  static   public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
     int [] dp=new int[words.length];
        int maxResult=0;
     for(int i=1;i<words.length;i++){
         for(int j=i-1;j>=0;j--){
             if(isPrecessor(words[j],words[i])){
                 dp[i]=Math.max(dp[i],dp[j]+1);
                 maxResult=Math.max(maxResult,dp[i]);
             }
         }
     }

        return maxResult+1;
    }
   static boolean isPrecessor(String word1,String word2){
        if(word1.length()==word2.length()) return false;
        String longWord="";
        String shortWord="";
        if(word1.length()>word2.length()){
          longWord=word1;
          shortWord=word2;
        }
        else {
            longWord=word2;
            shortWord=word1;
        }
        if(longWord.length()-shortWord.length()!=1) return false;
        int flag=0;
        for(int i=0,j=0;i<shortWord.length();i++,j++){
            if(flag>1) return false;
            if(shortWord.charAt(i)==longWord.charAt(j)) continue;
            else {
               flag++;
               i--;
            }
        }
        return true;
    }

    //用HashMap来做，也是Dp的原理
/*    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) return 0;
        int res = 0;
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        HashMap<String, Integer> map = new HashMap();
        //依次遍历每个字符串
        for (String word : words) {
            if (map.containsKey(word)) continue;
            map.put(word, 1);
            //依次删除一个字母
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String next = sb.toString();
                //若包含这个字串，且chain大于
                if (map.containsKey(next) && map.get(next) + 1 > map.get(word)) {
                    //则更新这个word
                    map.put(word, map.get(next) + 1);
                }
            }
            //每次遍历更新res
            if (map.get(word) > res) res = map.get(word);
        }
        return res;
    }*/


    public static void main(String[] args) {
        longestStrChain(new String[]{"sgtnz","sgtz","sgz","ikrcyoglz","ajelpkpx","ajelpkpxm","srqgtnz","srqgotnz","srgtnz","ijkrcyoglz"});
        System.out.println(isPrecessor("sgtnz","srgtnz"));
    }
}
