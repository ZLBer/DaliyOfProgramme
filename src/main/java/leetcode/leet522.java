package leetcode;

import java.util.Arrays;

public class leet522 {


    //之前错误的想法
/*    public int findLUSlength(String[] strs) {
   Set<String> init=getSubsequenceSet(strs[0]);
      for(int i=1;i<strs.length;i++){
         Set<String> check=getSubsequenceSet(strs[i]);
         for(String s:check){
             if (init.contains(s)) {
                 init.remove(s);
             }
         }
      }
      int max=0;
      for(String s:init){
          max=Math.max(s.length(),max);
      }
      return max;
    }

  static   Set<String> getSubsequenceSet(String s){
        Set<String> res=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char pre=s.charAt(i);
            res.add(pre+"");
            for(int j = i+1; j<s.length(); j++){
             for(int k=j+1;k<=s.length();k++){
                 res.add(pre+s.substring(j,k));
             }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        getSubsequenceSet("abcd").forEach(System.out::println);
    }*/

//先排序 在比较   这题没意思
    public int findLUSlength(String[] strs) {
        if(strs.length==1) return strs[0].length();
        Arrays.sort(strs,(a,b)->a.length()!=b.length()?b.length()-a.length():a.compareTo(b));
        if(!strs[1].equals(strs[0])) return strs[0].length();
        int cur=2;
        boolean flag=true;
        while (cur<strs.length){
             flag=true;
             //跳过相等的
            if (!strs[cur].equals(strs[cur - 1]) && (cur == strs.length - 1 || !strs[cur].equals(strs[cur + 1]))) {
                //和前面所有的进行比较是不是子串
                for(int i=0;i<cur;i++){
                    if(isSubsequence(strs[i],strs[cur])){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    return strs[cur].length();
                }
            }
           cur++;
         }
        return -1;
    }

    public boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) == b.charAt(j)) j++;
            i++;
        }
        return j == b.length();
    }
}
