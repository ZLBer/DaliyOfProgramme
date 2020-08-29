package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet1540 {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length()!=t.length()) return false;
        int []count=new int[27];
        Set<Integer> visited=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
          char a=s.charAt(i),b=t.charAt(i);
          count[getDis(a,b)]++;
         }
        for (int i = 1; i < count.length; i++) {
          if((k/26+((k%26>=i)?1:0))<count[i]) return false;
        }
return true;

    }
    
   int  getDis(char a,char b){
        if(a<=b){
            return b-a;
        }else {
         return 'z'-a+b-'a'+1;
        }
   }
}
