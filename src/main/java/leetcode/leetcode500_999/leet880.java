package leetcode.leetcode500_999;

public class leet880 {
    // 超出内存限制
/*  static   public String decodeAtIndex(String S, int K) {
   String res="";
        for (int i = 0; i < S.length(); i++) {
          char c=S.charAt(i);
         if(Character.isLetter(c)){
             res+=c;
         }else {
             int num=c-'0';
             String temp="";
             while (num-->0){
                temp+=res;
             }
             res=temp;
         }
        if(res.length()>=K){
            return res.charAt(K-1)+"";
        }
        }
        return "";
    }*/


    //重新搞
 static    public String decodeAtIndex(String S, int K) {
      long size=0;
      int i=0;
        for ( i = 0; i < S.length()&&size<K; i++) {
          char c=S.charAt(i);
            if(Character.isLetter(c)){
                size++;
            }else {
                size*=(c-'0');
            }
        }
        for ( i =i-1 ; i >= 0; i--) {
           char c=S.charAt(i);
          K%=size;
           if(K==0&&Character.isLetter(c)){
               return c+"";
           }
          if(Character.isLetter(c)){
              size--;
          }else {
              size/=(c-'0');
          }
        }
        return "";
    }


    public static void main(String[] args) {
        decodeAtIndex("leet2code3" ,
                10);
    }
}
