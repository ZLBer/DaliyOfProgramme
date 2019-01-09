package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by libin on 2019/1/8.
 */
public class leet345 {
  static   public String reverseVowels(String s) {
        char[]S=s.toCharArray();
        s=s.toLowerCase();
        Set<Character> vol=new HashSet<>();
        vol.add('a');
        vol.add('e');
        vol.add('i');
        vol.add('o');
        vol.add('u');
   int i=0,j=s.length()-1;
while (i<j){
  //  System.out.println(i+"      "+j);
    while (i<s.length()&&!vol.contains(s.charAt(i)))i++;
    while (j>=0&&!vol.contains(s.charAt(j)))j--;
  //  System.out.println(S[i]+"   "+S[j]);
       if(i<j) {
           char temp = S[i];
           S[i] = S[j];
           S[j] = temp;
        i++;
        j--;  }

}

StringBuilder sb=new StringBuilder();
for(char a:S){
    sb.append(a);
}
return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
}
