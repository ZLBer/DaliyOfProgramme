package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LCP20 {




   //这方法基本就废了 记住dfs只能往一个放想走，继往前又往后不可取
/*   static HashMap<Long,Long> map=new HashMap<>();
   static public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {

return  (int)dfs(0,target,inc,dec,jump,cost);
    }
  static  long  dfs(long cur,int target,int inc,int dec,int []jump,int []cost){
        if(target==cur) return 0;

        if(cur<0) return Integer.MAX_VALUE;

        if(cur>target){
            return (int)(cur-target)*dec;
        }
        long min=Integer.MAX_VALUE;
        if(map.containsKey(cur)) return map.get(cur);
      //向前
        min=Math.min(min,dfs(cur+1,target,inc,dec,jump,cost)+inc);

        min=Math.min(min,dfs(cur-1,target,inc,dec,jump,cost)+inc);
        if(cur!=0) {
            for (int i = 0; i < jump.length; i++) {
                min = Math.min(min, dfs(jump[i] * cur, target, inc, dec, jump, cost) + cost[i]);
            }
        }

        map.put(cur,min);
        return min;
    }*/

    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {

        return (int)(helper(target,target,inc,dec,jump,cost,new HashMap<>())%mod);
    }

    int mod=1000000007;
    long helper(long cur, int target, long inc, long dec, int []jump, int []cost, Map<Long,Long> map){
        if(cur==0) return 0;

        if(map.containsKey(cur)) return map.get(cur);
        long min=cur*inc;


        //两种方式选一种就行，都是防止死循环
        if(cur==1) return inc;
        // map.put(cur,(long)Integer.MAX_VALUE);


        for (int i = 0; i < jump.length; i++) {

            if (cur % jump[i] == 0) {
                min = Math.min(min, helper(cur / jump[i], target, inc, dec, jump, cost, map) + cost[i]);
            } else {
                long m = cur % jump[i];

                if (cur - m > 0) {
                    min = Math.min(min, helper(cur / jump[i], target, inc, dec, jump, cost, map) + cost[i] + (m * inc));
                }
                min = Math.min(min, helper(cur / jump[i] + 1, target, inc, dec, jump, cost, map) + cost[i] + (jump[i] - m) * dec);
            }
        }

        map.put(cur,min);
        return min;
    }
    public static void main(String[] args) {
       // busRapidTransit(31,5,3,new int[]{6},new int[]{10});
    }

}
