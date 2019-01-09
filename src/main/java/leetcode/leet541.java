package leetcode;

/**
 * Created by libin on 2019/1/8.
 */
public class leet541 {
  static   public String reverseStr(String s, int k) {
        char []S=s.toCharArray();
       for(int i=0;i<s.length();){
           if (i+2*k<s.length()){
               System.out.println("A");
               S=reverse(S,i,i+k-1);
               i+=2*k;
           }
           else if(i+k<s.length()){
               System.out.println("B");
              S= reverse(S,i,i+k-1);
              break;
           }
           else {
               System.out.println("C");
              S= reverse(S,i,S.length-1);
              break;
           }
       }
       return String.valueOf(S);
    }


  static   char[] reverse(char [] s,int begin,int end){
       while(begin<end){
           char temp=s[begin];
           s[begin++]=s[end];
           s[end--]=temp;
       }
       return s;
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcd",4));
    }
}
