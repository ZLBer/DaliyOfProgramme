package leetcode;

/**
 * Created by libin on 2017/9/16.
 */
public class Longest_Uncommon_Subsequence_I {
//    public int findLUSlength(String a, String b) {
//        int result = 0;
//        int count = 0;
//        int[] s = new int[a.length()];
//        for (int i = 0; i < a.length(); i++)
//            for (int j = 0; j < b.length(); j++) {
//                if (a.charAt(i) == b.charAt(j)) break;
//                else if (j == b.length()-1) s[i] = 1;
//            }
//        BnArrayUtil.traversalOutArray(s);
//        for (int i = 0; i < s.length; i++) {
//            if (s[i] == 1) count++;
//            else {
//                count = 0;
//                if (count > result) result = count;
//            }
//        }
//        if (count > result) result = count;
//        if(result==0) result=-1;
//        return result;
//    }

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

}
