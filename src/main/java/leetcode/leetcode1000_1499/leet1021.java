package leetcode.leetcode1000_1499;

/**
 * Created by libin on 2019/3/27.
 */
public class leet1021 {
    public String removeOuterParentheses(String S) {


        StringBuilder result=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        int count=0;
        for (int i = 0; i < S.length(); i++) {
         char a=S.charAt(i);

         if(a=='('){
             temp.append('(');
             count++;
         }
         else if(a==')'&&count!=1){
             temp.append(')');
             count--;
         }
         else {
             result.append(temp.toString().substring(1,temp.length()));
             temp=new StringBuilder();
             count=0;
         }
        }



        return result.toString();
    }
    //大神的做法 追求简洁和优雅
  /*  public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }*/
}
