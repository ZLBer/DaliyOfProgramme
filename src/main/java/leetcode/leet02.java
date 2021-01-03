package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet02 {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        int mod=(int)1e9+7;
        for (int i = 0; i < deliciousness.length; i++) {
            int sum = 1;
            if (map.containsKey(sum - deliciousness[i])) {
                res += map.get(sum - deliciousness[i]);
            }
            res%=mod;
            for (int j = 0; j <= 20; j++) {
                sum <<= 1;
                if (map.containsKey(sum - deliciousness[i])) {
                    res += map.get(sum - deliciousness[i]);
                    res%=mod;
                }
            }
        map.put(deliciousness[i],map.getOrDefault(deliciousness[i],0)+1);
        }
        return (int)res;
    }
}
