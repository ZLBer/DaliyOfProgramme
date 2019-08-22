package leetcode;

public class leet1160 {
    public int countCharacters(String[] words, String chars) {
       int [] letters=new int[26];
       int res=0;
       for(char c:chars.toCharArray()){
           letters[c-'a']++;
       }

        for (int i = 0; i < words.length; i++) {
             int []temps=new int[26];
             boolean flag=false;
             for(char c:words[i].toCharArray()){
                 temps[c-'a']++;
                 if(temps[c-'a']>letters[c-'a']) {
                    flag=true;
                     break;
                 }
             }
             if(!flag)
                 res+=words[i].length();
        }

        return res;
    }
}
