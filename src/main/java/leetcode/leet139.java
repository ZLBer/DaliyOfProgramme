package leetcode;

import java.util.List;

public class leet139 {

    //DFS  TLE
/*
    public boolean wordBreak(String s, List<String> wordDict) {
        Collections.sort(wordDict, Comparator.reverseOrder());
        System.out.println(wordDict.get(0));
     return  DFS(0,s,wordDict);
    }

   boolean DFS(int index,String s,List<String> wordDict){
        if(index>=s.length()){
            return true;
        }

       for (int i = 0; i < wordDict.size(); i++) {
           String word=wordDict.get(i);
           if(index+word.length()>s.length()) continue;
           if(s.substring(index,index+word.length()).equals(word))
               if(DFS(index+word.length(),s,wordDict)) return true;
       }
       return false;
   }
*/


    public boolean wordBreak(String s, List<String> wordDict) {
        boolean []dp=new boolean[s.length()+1];
        dp[0]=true;
     for(int i=1;i<dp.length;i++){
         for (String word : wordDict) {
             if (i - word.length() >= 0) {
                 if(dp[i-word.length()]){
                     if(word.equals(s.substring(i-word.length(),i))){
                         dp[i]=true;
                         break;
                     }

                 }
             }
         }
     }
     return dp[s.length()];
    }


    //另一种dp
 /*   public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        boolean []dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<s.length();i++){
            for(int j=0;j<i;j++){
                 if(dp[j]&&set.contains(s.substring(j,i))){
                     dp[i]=true;
                     break;
                 }
            }
        }
    return dp[s.length()];
    }*/

}
