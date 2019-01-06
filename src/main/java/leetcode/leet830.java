package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by libin on 2019/1/2.
 */
public class leet830 {
    //先转化成数组,用ArrayList  更快
//  static   public List<List<Integer>> largeGroupPositions(String S) {
//        List<List<Integer>>result= new ArrayList<>();
//         char s[]= S.toCharArray();
//         int count=1; int begin=0;
//      int i=1;
//for (;i<s.length;i++){
//
//
//          if(s[i]==s[i-1]) count++;
//          else {
//              if(count>=3) {
//
//                  result.add(Arrays.asList(new Integer[]{begin, i - 1}));
//
//              }
//              count =1;
//              begin = i;
//          }
//
//}
//   if(i==s.length&&count>=3)   result.add(Arrays.asList(new Integer[]{begin, i - 1}));
//
//         return   result;
//    }

     //慢了
//    static   public List<List<Integer>> largeGroupPositions(String S) {
//        List<List<Integer>>result= new ArrayList<>();
//
//        int count=1; int begin=0;
//        int i=1;
//        for (;i<S.length();i++){
//
//
//            if(S.charAt(i)==S.charAt(i-1)) count++;
//            else {
//                if(count>=3) {
//
//                    result.add(Arrays.asList(new Integer[]{begin, i - 1}));
//
//                }
//                count =1;
//                begin = i;
//            }
//
//        }
//        if(i==S.length()&&count>=3)   result.add(Arrays.asList(new Integer[]{begin, i - 1}));
//
//        return   result;
//    }
    static public List<List<Integer>> largeGroupPositions(String S) {
         List<List<Integer>> res = new ArrayList<>();
         if (S == null || S.length() == 0) {
             return res;
         }
         int start = 0;
         for (int i = 1; i < S.length(); i++) {
             if (S.charAt(i) != S.charAt(start)) {
                 if (i - start >= 3) {
                     res.add(Arrays.asList(start, i - 1));
                 }
                 start = i;
             }
         }
         if (S.length() - start >= 3) {
             res.add(Arrays.asList(start, S.length() - 1));
         }
         return res;
     }
    public static void main(String[] args) {
        List<List<Integer>> r=largeGroupPositions("aaa");

            for(List s: r){
            for(Object a:s){
                System.out.println((Integer) a);
            }
        }
    }
}
