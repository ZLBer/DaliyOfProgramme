package leetcode.leetcode1000_1499;

public class leet1309 {
    public String freqAlphabets(String s) {
      StringBuilder sb=new StringBuilder();
      for(int i=0;i<s.length();){
         if(i+2<s.length()&&s.charAt(i+2)=='#'){
             sb.append((char)('a'+Integer.valueOf(s.substring(i,i+2))-1));
             i+=3;
         }else {
             sb.append((char)( 'a'+ s.charAt(i++)-'0'-1));
         }
      }
      return sb.toString();
    }
}
