package leetcode;

/**
 * Created by libin on 2019/1/27.
 */
public class leet984$ {
    //贪心法 ，我觉得一点也不easy
    //按照谁多写谁的原则添加，若出现两个一样的则添加另一个
   /* public String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();

        while (A > 0 || B > 0) {
            //是否写A标志
            boolean writeA = false;
            int L = ans.length();
            //连续出现两个A或者B
            if (L >= 2 && ans.charAt(L-1) == ans.charAt(L-2)) {
                //加入出现两个连续的b，则下一个需要写A
                if (ans.charAt(L-1) == 'b')
                    writeA = true;
            } else {//如果没出现两个连续的字母 ，则谁余下的多写谁
                if (A >= B)
                    writeA = true;
            }

            //开始写A或者写B
            if (writeA) {
                A--;
                ans.append('a');
            } else {
                B--;
                ans.append('b');
            }
        }

        return ans.toString();
    }
*/

   //额 ，难以置信的做法
  //这么想，一开始a的数量一定大于b，所以可以依次加两个a，然后ab相同，可以各加一个
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder(A + B);
        char a = 'a', b = 'b', i = (char)A, j = (char)B;
        if (B > A) { a = 'b'; b = 'a'; i = (char)B; j = (char)A; }
        while (i > 0 || j > 0) {
            if (i > 0) { res.append(a); --i; }
            if (i > j) { res.append(a); --i; }
            if (j > 0) { res.append(b); --j; }
        }
        return res.toString();
    }
}
