package leetcode;

/**
 * Created by libin on 2019/1/6.
 */
public class leet709 {
    public String toLowerCase(String str) {
 return  str.toLowerCase();
    }

  //不适用已有的方法
//    public String toLowerCase(String str) {
//        char[] a = str.toCharArray();
//        for (int i = 0; i < a.length; i++)
//            if ('A' <= a[i] && a[i] <= 'Z')
//                a[i] = (char) (a[i] - 'A' + 'a');
//        return new String(a);
//    }
}
