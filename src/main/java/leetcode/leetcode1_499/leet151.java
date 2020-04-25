package leetcode.leetcode1_499;

import java.util.Arrays;
import java.util.Collections;

public class leet151 {

    //mine
/*    public String reverseWords(String s) {
      String []arrs=s.split("\\s+");
      StringBuilder sb=new StringBuilder();
        System.out.println(arrs.length);
      for (int i = arrs.length - 1; i >= 0; i--) {
        if("".equals(arrs[i])) continue;
               sb.append(arrs[i]+" ");
        }
      String res=sb.toString();

      return  "".equals(res)?"":res.substring(0,res.length()-1);
    }*/

    //先trim可以防止先导的空格  省的判断空字符串
    //用join省去了最后把答案分隔
    //多了解点库函数可以节省多少时间呢
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
    //用Scanner 跳过空字符串
/*    public String reverseWords(String s) {
        Scanner parts = new Scanner(s);

        String result = "";

        while(parts.hasNext()){
            result = parts.next() + " " + result;
        }

        return result.trim();
    }*/


    //来了来了 没有任何库函数的实现
    //基本思路是 先反转字符串，再反转单词，最后清理空格
/*   public String reverseWords(String s) {
       if (s == null) return null;

       char[] a = s.toCharArray();
       int n = a.length;

       // step 1. reverse the whole string
       reverse(a, 0, n - 1);
       // step 2. reverse each word
       reverseWords(a, n);
       // step 3. clean up spaces
       return cleanSpaces(a, n);
   }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }*/
}
