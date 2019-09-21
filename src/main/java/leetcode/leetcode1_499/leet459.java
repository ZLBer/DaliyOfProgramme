package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/1/8.
 */
public class leet459 {
    //自己的解决方案  先遍历找到匹配字符串
   static public boolean repeatedSubstringPattern(String s) {
        for(int i=1;i<s.length();i++) {
           // System.out.println("i"+i);
            int j = i;  int temp = 0;

            for (; j < s.length(); j++) {

            //    System.out.println("  "+s.charAt(j)+"     "+s.charAt(temp));
                if (s.charAt(j) != s.charAt(temp++)) {

                  //  System.out.println("breaklelelele");
                    break;
                }

            }
         //   System.out.println("j   "+j);
            if (j == s.length() ) {
             //   System.out.println(i);
             //   System.out.println(s.substring(i,s.length()));
               if(matche(s,s.substring(i,s.length()))){
                   return true;
               }
            }
        }
        return false;
    }
    //字符串匹配算法
   static boolean matche(String s,String r){
       //如果不能除尽，则false
       if(s.length()%r.length()!=0) return false;
         //从头开始匹配
            int index=0;
        while(index<s.length()){
            int end=index+r.length();
            for(;index<end;index++)
                if(s.charAt(index)!=r.charAt(index%r.length())) return false;
        }
   return true;
    }
  //大佬的方法   基本思想就是：重复的字符传一定是源字符串的倍数，然后从源字符串的一半开始 ，组装起来的字符串和源字符串相等则true
/*    public boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        for(int i=l/2;i>=1;i--) {
            if(l%i==0) {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) return true;
            }
        }
        return false;
    }*/


    public static void main(String[] args) {
       // System.out.println(matche("abcabcabcabc","ab"));
        System.out.println(repeatedSubstringPattern("aba"));
    //    System.out.println("abcabcabcabc".substring(6,"abcabcabcabc".length()));
    }

}
