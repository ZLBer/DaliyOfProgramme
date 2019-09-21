package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/2/26.
 */
public class leet796 {
    //mine  暴力法直接做
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length()) return false;
        if(A.length()==0)return true;
         int index=0;

         while (index<A.length()){
             int i=index;
             int j=0;
             int count=0;

         while (j<B.length()) {

             if(i==A.length())  i=0;
             if (A.charAt(i) == B.charAt(j)) {
                 i++;
                 j++;
                 count++;
             } else break;

         }
if(count==A.length()) return true;


         index++;
         }
return false;
    }

    //woc  nice！！！
    /*
  We can easily see whether it is rotated if B can be found in (A + A).
For example, with A = "abcde", B = "cdeab", we have

“abcdeabcde” (A + A)
  “cdeab” (B)
     */

    /*public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }*/
}
