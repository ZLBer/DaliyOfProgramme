package leetcode.leetcode500_999;

public class leet806 {
    public int[] numberOfLines(int[] widths, String S) {

       int line=1;
       int temp=0;
       char []chars=S.toCharArray();
       for(char c:chars){
           temp+=widths[c-'a'];
           if (temp>100) {
               line++;
               temp=widths[c-'a'];
           }
           else if(temp==100){
               temp=0;
               line++;
           }
       }

       return new int[]{line,temp};
     }
}
