package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by libin on 2019/1/7.
 */
public class leet917 {
    //双指针
  static   public String reverseOnlyLetters(String S) {
        char[] s = S.toCharArray();

        int i = 0, j = S.length() - 1;
        char temp;
        while (i < j) {
        System.out.println(i);
        while ((i<s.length)&&(s[i]<'A'||(s[i]>'Z'&&s[i]<'a')||s[i]>'z')){
            i++;
        }
        while (j>=0&&(s[j] <'A'||(s[j]>'Z'&&s[j]<'a')||s[i] >'z')) j--;
        if(i<j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

    }
    StringBuilder SB=new StringBuilder();
        for(char a:s){
        SB.append(a);
    }
        return SB.toString();
}

//双指针更简便的写法
//    public String reverseOnlyLetters(String S) {
//        StringBuilder sb = new StringBuilder(S);
//        for (int i = 0, j = S.length() - 1; i < j; ++i, --j) {
//            while (i < j && !Character.isLetter(sb.charAt(i))) ++i;
//            while (i < j && !Character.isLetter(sb.charAt(j))) --j;
//            sb.setCharAt(i, S.charAt(j));
//            sb.setCharAt(j, S.charAt(i));
//        }
//        return sb.toString();
//    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("7_28]"));
    }
}