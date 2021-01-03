package leetcode;

import java.util.Arrays;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class leet956 {

/*    public int tallestBillboard(int[] rods) {

        //key是a-b  val是a
        //最终目标是 a-b=0，且a最大
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        for (int rod : rods) {
            Map<Integer,Integer> cp=new HashMap<>(map);
            for (Integer key : cp.keySet()) {
                //差距一样的情况下  a越高越好啊
                //放到a
                map.put(key+rod,Math.max(map.getOrDefault(key+rod,0),cp.get(key)+rod));
                //放到b
                map.put(key-rod,Math.max(map.getOrDefault(key-rod,0),cp.get(key)));
            }


        }
        return map.getOrDefault(0,-1);
    }*/


    //这样的好理解多了  和上面的思想类似
    //但是差值这个状态真不好想  其实目标就是求差=0，那dp状态里自然得包含差值
    public int tallestBillboard(int[] rods) {
        if (rods.length == 0) return 0;
        int sum = Arrays.stream(rods).sum();
        int[][] dp = new int[rods.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -(int) 1e9);
        }
        dp[0][rods[0]] = rods[0]; //放进一个去
        dp[0][0] = 0;  //什么都不放

        for (int i = 1; i < rods.length; i++) {
            for (int j = 0; j <= sum; j++) {
                // 一个也不加
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

                //把i放到大的里面
                int add = j + rods[i];
                if (add <= sum)
                    dp[i][add] = Math.max(dp[i][add], dp[i - 1][j] + rods[i]);
                //把i放到小的里面
                int del = Math.abs(j - rods[i]);
                dp[i][del] = Math.max(dp[i][del], dp[i - 1][j] + rods[i]);
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }


        return dp[rods.length - 1][0] / 2;
    }
}
