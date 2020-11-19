package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leet140 {

    //memo
   static public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> lists = helper(s, 0, new HashSet<>(wordDict));
        List<String> res=new ArrayList<>();
        for (List<String> list : lists) {
            res.add(String.join(" ",list));
        }
        return res;

    }

   static Map<Integer,List<List<String>>> memo=new HashMap<>();


   static List<List<String>> helper(String s, int index, Set<String> wordDic){

       if(index>=s.length()){
           List<List<String>> res=new ArrayList<>();
           res.add(new ArrayList<>());
           return res;
       }

       if(memo.containsKey(index)) return memo.get(index);


        List<List<String>> res=new ArrayList<>();
        for(int i=index+1;i<=s.length();i++){
           String ts=s.substring(index,i);
           if(wordDic.contains(ts)){

               List<List<String>> lists = helper(s, i, wordDic);

               int a=1;
               for (List<String> list : lists) {
                   List<String> temp=new ArrayList<>();
                   temp.add(ts);
                   temp.addAll(list);
                   res.add(temp);
               }

           }
        }
      memo.put(index,res);

      return res;
    }

    public static void main(String[] args) {
         wordBreak("cat", Arrays.asList("cat"));
    }

}
