package leetcode.leetcode1000_1499;

public class leet1422 {
    //mine
    public int maxScore(String s) {
        int countZero=0;
        int countOne=0;
        int res=0;
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)=='1') countOne++;
    }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') countZero++;
            else countOne--;

            res=Math.max(res,countOne+countZero);
        }

     return res;
    }


    //一次遍历
  /*  public int maxScore(String s) {
        int zeros = 0, ones = 0, max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '0') zeros++; else ones++;
            if(i != s.length()-1) max = Math.max(zeros - ones, max);
        }
        return max + ones;
    }*/
}
