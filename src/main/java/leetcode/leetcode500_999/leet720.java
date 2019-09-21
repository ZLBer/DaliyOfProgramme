package leetcode.leetcode500_999;

import leetcode.LQTest.A;

import java.util.*;

public class leet720 {
    //mine 十分冗长
 /*   public String longestWord(String[] words) {
        Set<String> set =new HashSet<>();
        for(String s:words){
            set.add(s);
        }
        List<String> result=new LinkedList<>();
        int maxLength=0;
        for(int i=0;i<words.length;i++){
            boolean flag=true;
           for(int j=1;j<words[i].length();j++){
               if(set.contains(words[i].substring(0,j))) continue;
               else {
                   flag=false;
                   break;
               }
           }
            if (flag&&words[i].length()>maxLength){
                maxLength=words[i].length();
                result=new LinkedList<>();
                result.add(words[i]);
            }
            else if(flag&&words[i].length()==maxLength){
                result.add(words[i]);
            }
        }
        for(String s:result){
            System.out.println(s);
        }
        String r=result.get(0);
     for(int i=1;i<result.size();i++){
         if(result.get(i).compareTo(r)>0){
                r=result.get(i);
         }
     }
     return r;
    }*/

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }
}
