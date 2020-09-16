package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet1073$ {
    //对于二进制这种东西，真的不好理解
    public int[] addNegabinary(int[] A, int[] B) {
        List<Integer> res=new ArrayList<>();
        //carry表示进位
        int carry = 0, i = A.length - 1, j = B.length - 1;
        while (i >= 0 || j >= 0 || carry!=0) {
            if (i >= 0) carry += A[i--];
            if (j >= 0) carry += B[j--];
            //计算一位
            res.add(carry & 1);
            //进位其实是抵消了前一位的一个数
            carry = -(carry >> 1);
        }

        //去除开头的0
        while (res.size() > 1 && res.get(res.size()-1) == 0)
            res.remove(res.size()-1);
        //反转
        Collections.reverse(res);
        int []r=new int[res.size()];
        for (int i1 = 0; i1 < r.length; i1++) {
              r[i1]=res.get(i1);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(1&-1));
        //>>是带符号右移，补符号位   >>>是无符号右移，全部补0
        System.out.println(Integer.toBinaryString(-1>>1));
    }
}
