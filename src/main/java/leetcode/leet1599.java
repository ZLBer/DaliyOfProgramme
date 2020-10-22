package leetcode;

public class leet1599 {

    //contest
/*    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        int pre=0;
        int res=0;
        int cus=0;
        int all;
        int i=0;
        int count=-1;
        for ( ; i < customers.length; i++) {
           pre+=customers[i];
           if(pre>4){
               pre-=4;
               cus+=4;
           }else {
             cus+=pre;
             pre=0;
           }
          //  System.out.println(i+" "+res);
           if(res<boardingCost*cus-runningCost*(i+1)){
               res=boardingCost*cus-runningCost*(i+1);
               count=i+1;
           }
        }
     while (pre>0){
         if(pre>4){
             pre-=4;
             cus+=4;
         }else {
             cus+=pre;
             pre=0;
         }
        // System.out.println(i+" "+res);

         if(res<boardingCost*cus-runningCost*(i+1)){
             res=boardingCost*cus-runningCost*(i+1);
             count=i+1;
         }
         i++;
     }
     return count;
    }*/

    //mine   优化代码 合并成一个循环

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int pre=0;
        int res=0;
        int cus=0;
        int i=0;
        int count=-1;
        for ( ; i < customers.length||pre>0; i++) {
           if(i<customers.length) pre+=customers[i];
            if(pre>4){
                pre-=4;
                cus+=4;
            }else {
                cus+=pre;
                pre=0;
            }
            if(res<boardingCost*cus-runningCost*(i+1)){
                res=boardingCost*cus-runningCost*(i+1);
                count=i+1;
            }
        }
        return count;
    }
}
