package leetcode;

/**
 * Created by libin on 2019/1/7.
 */
public class leet551 {
    public boolean checkRecord(String s) {
       int countA=0;
       int countinueL=0;
          for(int i=0;i<s.length();i++){
             if(s.charAt(i)=='A'){
                 countA++;
                 countinueL=0;
                 if(countA>1) return false;
             }
             else if(s.charAt(i)=='L'){
                 countinueL++;
                 if(countinueL>2) return false;
             }
             else {
                 countinueL=0;
             }
          }
          return true;
    }
  //用正则表达式..
/*
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
*/


}
