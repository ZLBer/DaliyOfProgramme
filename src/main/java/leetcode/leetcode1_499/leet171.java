package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/2/23.
 */
public class leet171 {
    //看成26进制
    public int titleToNumber(String s) {
        //  "AAA"
         int digit=s.length(); // digit=3
         int result=0;
         while (digit>0){
             //每增加一位表示26的n次方
             result+=(s.charAt(digit-1)-'A'+1)*Math.pow(26,s.length()-digit);
         }
return result;
    }

  /*  public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++) ;
        return result;
    }*/
}
