package leetcode;

public class leet1318 {
    //mine  当时思路特别混乱
  /*  public int minFlips(int a, int b, int c) {

        String sa = Integer.toBinaryString(a);
        String sb = Integer.toBinaryString(b);
        String sc = Integer.toBinaryString(c);
        while (sa.length() < 32) {
            sa = "0" + sa;
        }
        while (sb.length() < 32) {
            sb = "0" + sb;
        }
        while (sc.length() < 32) {
            sc = "0" + sc;
        }
        int index = 0;
        int res = 0;
        for (int i = 0; i < sa.length(); i++) {
            if (sc.charAt(i) == '1') {
                if (sa.charAt(i) == '1' || sb.charAt(i) == '1') continue;
                else res++;
            } else {
                if (sa.charAt(i) == '1') res++;
                if (sb.charAt(i) == '1') res++;
            }
        }

   return res;
    }*/


    //这个挺清晰的
    public int minFlips(int a, int b, int c) {
        int res = 0;
        while (a != 0 || b != 0 || c != 0) {
            int t = a & 1;
            int m = b & 1;
            int n = c & 1;
            if ((t | m) != n) {
                if (n == 0) {
                    if (t == 1) {
                        res++;
                    }
                    if (m == 1) {
                        res++;
                    }
                } else {
                    res++;
                }
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return res;
    }




}
