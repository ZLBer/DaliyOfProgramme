package leetcode.leetcode1000_1499;

import java.util.PriorityQueue;

public class leet1405 {

    //mine 贪心
    //每次找数量最大的那个 ，然后配对一个第二大的（一个或者两个）
/*
    public String longestDiverseString(int a, int b, int c) {
    Integer[][]abc=new Integer[3][2];
    abc[0][0]=a;abc[1][0]=b;abc[2][0]=c;
    abc[0][1]=0;abc[1][1]=1;abc[2][1]=2;
    StringBuffer res=new StringBuffer();
        Arrays.sort(abc,(a0,b0)->b0[0]-a0[0]);
        while (abc[0][0]>0){
        int count=Math.min(2,abc[0][0]);
        res.append(helper((char)(abc[0][1]+'a'),count));
        abc[0][0]-=count;
        if(abc[1][0]==0) break;

        if(abc[1][0]>=abc[0][0]){
            count=Math.min(abc[1][0],2);
        }else {
            count=1;
        }
        res.append(helper((char)(abc[1][1]+'a'),count));
        abc[1][0]-=count;
        Arrays.sort(abc,(a0,b0)->b0[0]-a0[0]);

    }
        return res.toString();
    }

    String helper(char c,int count){
        String res="";
        for (int i = 0; i < count; i++) {
             res+=c;
        }
        return res;
    }
*/



    //方法是一样的  改成堆，不用每次都排序
    static public String longestDiverseString(int a, int b, int c) {

        StringBuilder builder = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
                (count1, count2) -> Integer.compare(count2.count, count1.count));

        if (a > 0)
            pq.add(new Pair('a', a));
        if (b > 0)
            pq.add(new Pair('b', b));
        if (c > 0)
            pq.add(new Pair('c', c));

        while (pq.size() > 1) {

            Pair pair_one = pq.poll();
            if (pair_one.count >= 2) {
                builder.append(pair_one.ch);
                builder.append(pair_one.ch);
                pair_one.count -= 2;
            } else {
                builder.append(pair_one.ch);
                pair_one.count -= 1;
            }

            Pair pair_two = pq.poll();
            if (pair_two.count >= 2 && pair_one.count < pair_two.count) {
                builder.append(pair_two.ch);
                builder.append(pair_two.ch);
                pair_two.count -= 2;
            } else {
                builder.append(pair_two.ch);
                pair_two.count -= 1;
            }

            if (pair_one.count > 0)
                pq.add(pair_one);
            if (pair_two.count > 0)
                pq.add(pair_two);
        }

        if (!pq.isEmpty()) {
            if (builder.charAt(builder.length() - 1) != pq.peek().ch) {
                if (pq.peek().count >= 2) {
                    builder.append(pq.peek().ch);
                    builder.append(pq.peek().ch);
                } else {
                    builder.append(pq.peek().ch);
                }
            }
        }
        return builder.toString();
    }

    static class Pair {
        public Character ch;
        int count;

        public Pair(Character ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

   //一样的想法 ，递归实现
/*    String generate(int a, int b, int c, String aa, String bb, String cc) {
        if (a < b)
            return generate(b, a, c, bb, aa, cc);
        if (b < c)
            return generate(a, c, b, aa, cc, bb);
        if (b == 0)
            return aa.repeat(Math.min(2, a));
        int use_a = Math.min(2, a), use_b = a - use_a >= b ? 1 : 0; //遍历的周期不一样
        return aa.repeat(use_a) + bb.repeat(use_b) +
                generate(a - use_a, b - use_b, c, aa, bb, cc);
    }
    public String longestDiverseString(int a, int b, int c) {
        return generate(a, b, c, "a", "b", "c");
    }*/
}
