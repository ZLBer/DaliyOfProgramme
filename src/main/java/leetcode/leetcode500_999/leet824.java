package leetcode.leetcode500_999;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by libin on 2019/1/22.
 */
public class leet824 {
  static   public String toGoatLatin(String S) {
         String []words= S.split(" ");
        HashSet<Character> vowel=new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
         String append="a";
         String result="";
          for(String a:words){
              if(vowel.contains(a.charAt(0)))  {
                  a+="ma"+append;
              }
             else  a=a.substring(1)+a.charAt(0)+"ma"+append;
             append+="a";
             result+=a+" ";
              System.out.println(result);
          }

          return result.substring(0,result.length()-1);

    }

   /* public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<Character>();
        for (char c : "aeiouAEIOU".toCharArray()) vowel.add(c);
        String res = "";
        int i = 0, j = 0;
        for (String w : S.split("\\s")) {
            res += ' ' + (vowel.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (j = 0, ++i; j < i; ++j) res += "a";
        };
        return res.substring(1);
    }*/





    public static void main(String[] args) {
        toGoatLatin("The quick brown fox jumped over the lazy dog");
    }
}
