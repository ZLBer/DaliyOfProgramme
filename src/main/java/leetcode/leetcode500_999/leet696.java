package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/7.
 */
public class leet696 {
    //暴力法 超时
   static public int countBinarySubstrings(String s) {
        char[] S = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int count0 = 0, count1 = 0;
            int ti = i;
            if (S[ti] == '0') {
                while (ti < s.length() && S[ti] == '0') {
                    count0++;
                    ti++;
                }
                boolean flag=true;
             //   System.out.println("count0"+count0);
                while (ti < s.length() && count0>0) {
                    if (S[ti]=='1') {
                        ti++;
                        count0--;
                     }
                     else {
                        flag=false;
                        break;
                    }
                }
                if (flag&&count0==0) count++;
              //  System.out.println("count      "+count);

            } else {
                while (ti < s.length() && S[ti] == '1') {
                    count1++;
                    ti++;
                }
             //   System.out.println("count1"+count1);
               boolean flag=true;
                while (ti < s.length() && count1> 0) {
                    if (S[ti]=='0') {
                        ti++;
                        count1--;
                    }
                    else {
                        flag=false;
                        break;
                    }
                }
                if (flag&&count1==0) count++;
              //  System.out.println("count    "+count);
            }
        }
        return  count;
    }
    //先分组，然后返回相邻组的最小值
//    public int countBinarySubstrings(String s) {
//        int[] groups = new int[s.length()];
//        int t = 0;
//        groups[0] = 1;
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i-1) != s.charAt(i)) {
//                groups[++t] = 1;
//            } else {
//                groups[t]++;
//            }
//        }
//
//        int ans = 0;
//        for (int i = 1; i <= t; i++) {
//            ans += Math.min(groups[i-1], groups[i]);
//        }
//        return ans;
//    }

    //也是分组的原理，但是不创建group数组，而是用pre ，cur两个变量来保存（貌似更慢了）
//    public int countBinarySubstrings(String s) {
//        int ans = 0, prev = 0, cur = 1;
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i-1) != s.charAt(i)) {
//                ans += Math.min(prev, cur);
//                prev = cur;
//                cur = 1;
//            } else {
//                cur++;
//            }
//        }
//        return ans + Math.min(prev, cur);
//    }
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110"));
    }

}
