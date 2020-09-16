package leetcode.leetcode1000_1499;

public class leet1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
       int not_X=0;
        for (int i = 0; i < grumpy.length; i++) {
             if(grumpy[i]==1) not_X+=customers[i];
        }
        int i=0;
        int result=0;
        while (i+X-1<grumpy.length){
            int temp=not_X;
            for(int j=i;j<=i+X-1;j++){
                 if(grumpy[j]==0) temp+=customers[j];
            }
            result=Math.max(result,temp);
            i++;
        }
        return result;
    }

 //可以用O(n)解决
   /* public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //max记录最大出=窗口，satisfy记录满意的人数
        int satisfy = 0, max = 0;
        for (int i = 0, win = 0; i < grumpy.length; ++i) {
            satisfy += grumpy[i] == 0 ? customers[i] : 0;
            //若满足
            win += grumpy[i] * customers[i];
            //向后滑动窗口
            if (i >= X) {
                win -= grumpy[i - X] * customers[i - X];
            }
            //记录最大窗口
            max = Math.max(win, max);
        }
        return satisfy + max;
    }*/
}
