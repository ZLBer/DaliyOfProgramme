package leetcode.leetcode1000_1499;

import java.util.regex.Pattern;

public class leet1071 {
    //mine 十分冗长
/*    public String gcdOfStrings(String str1, String str2) {
       String longStr="",shortStr="";
       int longLen=0,shortLen=0;
     if(str1.length()>=str2.length()){
         longStr=str1;
         shortStr=str2;
     }
     else {
         longStr=str2;
         shortStr=str1;
     }
     longLen=longStr.length();
     shortLen=shortStr.length();
     String T=shortStr;
     int count=1;
     while (T.length()>0){
         if(longLen%T.length()==0){
             int countT=longLen/T.length();
             StringBuilder sb=new StringBuilder();
             StringBuilder stringBuilder=new StringBuilder();
             while (countT-->0){
              sb.append(T);
             }
             countT=shortLen/T.length();
             while (countT-->0){
                 stringBuilder.append(T);
             }

             if(sb.toString().equals(longStr)&&stringBuilder.toString().equals(shortStr)) return T;
         }
         if(T.length()==1) return "";
         T=T.substring(0,shortStr.length()/++count);
     }
     return "";
    }*/

    //递归法 str1是长串，str2是短串
 /*   public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) { return gcdOfStrings(str2, str1); } // make sure str1 is not shorter than str2.
        else if (!str1.startsWith(str2)) { return ""; } // shorter string is not common prefix.
        else if (str2.isEmpty()) { return str1; } // gcd string found.
        else { return gcdOfStrings(str1.substring(str2.length()), str2); } // cut off the common prefix part of str1.
    }*/

    //正则表达式
    public String gcdOfStrings(String str1, String str2) {
        for (int i = str1.length(); i > 0; --i) {
            String p = '(' + str1.substring(0, i) + ")+";
            if (Pattern.compile(p).matcher(str1).matches()
                    && Pattern.compile(p).matcher(str2).matches()) {
                return str1.substring(0, i);
            }
        }
        return "";
    }
}
