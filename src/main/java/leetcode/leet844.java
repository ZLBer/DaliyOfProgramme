package leetcode;

import java.util.Stack;

/**
 * Created by libin on 2019/3/3.
 */
public class leet844 {
    //mine  遍历三次
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> a=new Stack<>();
        Stack<Character> b=new Stack<>();
      for(int i=0;i<S.length();i++){
          if(S.charAt(i)=='#'){
              if(a.size()==0) continue;
              a.pop();
          }
          else a.push(S.charAt(i));
      }
      for(int i=0;i<T.length();i++){
          if(T.charAt(i)=='#'){
              if(b.size()==0) continue;
              b.pop();
          }
          else b.push(T.charAt(i));
      }
      if(a.size()!=b.size()){return false;}
      for(int i=0;i<a.size();i++){
          if(a.pop()!=b.pop()) return false;
      }
      return true;
    }

/*

    //多优秀的代码..
//倒着遍历  遇到#往前跳两个
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            //这么理解  遇到# back置为1  当back为1或charAt(i)为#的时候继续往前走（这样就跳过了两个）
            for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); --i)
                back += S.charAt(i) == '#' ? 1 : -1;
            for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); --j)
                back += T.charAt(j) == '#' ? 1 : -1;
            //比较此处的字母是否相同，相同则都--
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--; j--;
            } else
                //是否都达到了最前面
                return i == -1 && j == -1;
        }
    }
    public static void main(String[] args) {

    }
   //把上面的代码压缩>>>>>>..
    public boolean backspaceCompare(String S, String T) {
        for (int i = S.length() - 1, j = T.length() - 1;; i--, j--) {
            for (int b = 0; i >= 0 && (b > 0 || S.charAt(i) == '#'); --i) b += S.charAt(i) == '#' ? 1 : -1;
            for (int b = 0; j >= 0 && (b > 0 || T.charAt(j) == '#'); --j) b += T.charAt(j) == '#' ? 1 : -1;
            if (i < 0 || j < 0 || S.charAt(i) != T.charAt(j)) return i == -1 && j == -1;
        }
    }

    */
}
