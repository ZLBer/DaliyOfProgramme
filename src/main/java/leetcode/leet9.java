package leetcode;

public class leet9 {
/*    public boolean isPalindrome(int x) {
    if(x<0)return false;
    StringBuilder sb=new StringBuilder(x+"");
   return sb.toString().equals(sb.reverse().toString());
    }*/

/*    public boolean isPalindrome(int x) {
        if(x<0)return false;
       String s=x+"";
      char[] chars= s.toCharArray();
      int left=0,right=0;

        for (int i = 0; i < chars.length; i++) {
             left=left*10+chars[i];
             right=right*10+chars[chars.length-1-i];

if(left!=right) return false;
        }
        return true;


    }*/


    public boolean isPalindrome(int x) {
        if(x<0)return false;
     int result=0;
   int temp=x;
      while (temp!=0){
         result=result*10+temp%10;
         temp=temp/10;
      }
        return x==result;
    }
/*    public boolean isPalindrome(int x) {
        if(x<0)return false;
        String s=x+"";
        char[] chars= s.toCharArray();
        int left=0,right=0;

        for (int i = 0; i < chars.length; i++) {
            left=left*10+chars[i];
        }
        for(int i=chars.length-1;i>=0;i--){
            right=right*10+chars[i];
        }

        return left==right;
    }*/
}
