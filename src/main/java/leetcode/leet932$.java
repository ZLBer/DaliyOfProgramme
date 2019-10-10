package leetcode;

import java.util.ArrayList;

public class leet932$ {

    //
   // 好似一个数学问题

    //左边是奇数 右边是偶数
    //小的可以生成大的
    public int[] beautifulArray(int N) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i : res) if (i * 2 - 1 <= N) tmp.add(i * 2 - 1);
            for (int i : res) if (i * 2 <= N) tmp.add(i * 2);
            res = tmp;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
     for ( int a:   new leet932$().beautifulArray(6)){
         System.out.println(a);
     }
    }
}
