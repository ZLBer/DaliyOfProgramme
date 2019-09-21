package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/3/4.
 */
public class leet134 {

    //mine 强行遍历
 static    public int canCompleteCircuit(int[] gas, int[] cost) {
     for(int i=0;i<gas.length;i++){
         int starting=i;
         int index=(i+1)%gas.length;
         int tank=gas[starting]-cost[starting];
         if(tank<0) continue;
         while (index!=starting){
          tank+=gas[index]-cost[index];
          if(tank<0) break;

             index=(index+1)%gas.length;
         }
         if(index==starting) return starting;
     }
     return -1;
    }



  //更优秀的做法
    //如果有解sumGas一定>=sumCost
    //解唯一，从该点开始往后都不可能存在负数，否则重新选取点
   /* public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }*/
    public static void main(String[] args) {
        canCompleteCircuit(new int[]{3,3,4},new  int[]{3,4,4});
    }
}
