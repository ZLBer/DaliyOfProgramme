package leetcode;

import java.util.Arrays;

public class leet1648 {


    //这是写的什么乱七八糟的  明显写复杂了感觉
    //优化下代码
    int mod=(int)1e9+7;
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int len=inventory.length;
        long res=0;

        for (int i = inventory.length - 1; i >= 0; i--) {
        long big = inventory[i],small=i==0?Integer.MIN_VALUE:inventory[i-1];
         if(orders>=(len-i)*(big-small)){
            res=(res+helper(small+1,big)*(len-i))%mod;
            orders-=(len-i)*(big-small);
           inventory[i]=(int)small;
         }else {
             System.out.println(orders+"  ");
           int cc=orders/(len-i);
           res=(res+helper(big-cc+1,big)*(len-i))%mod;
            orders-=cc*(len-i);
            big=big-cc;
            res=(res+orders*big)%mod;
           break;
         }
        }


        return  (int)res;
    }


     long helper (long a, long b) {
        long res= (a + b) * (b - a + 1) / 2;
        return res%mod;
    }





    //居然又可以二分？ 厉害了
 /*   Map<Integer, Integer> map = new HashMap<>();

    public int maxProfit(int[] inventory, int orders) {
        int mod = 1_000_000_007;

        long left = 0;
        long right = 0;

        for (int in : inventory) {
            map.put(in, map.getOrDefault(in, 0)+1);
            right = Math.max(right, in);
        }

        while (left <= right) {
            long mid = (left+right) / 2;
            if (valid(mid, orders)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        long total = 0;

        for (int number : map.keySet()) {
            if (number <= left) {
                continue;
            }
            int count = map.get(number);
            total = (total + (left + 1 + number) * (number - left) / 2 % mod * count % mod) % mod;
            orders -= (number - left) * count;
        }

        if (orders > 0) {
            total = (total + orders * left % mod) % mod;
        }

        return (int)total;

    }

    private boolean valid(long mid, int orders) {
        for (int number : map.keySet()) {
            if (number <= mid) {
                continue;
            }
            int count = map.get(number);
            orders -= (number - mid) * count;

            if (orders <= 0) {
                return true;
            }
        }

        return orders <= 0;
    }*/

    }
