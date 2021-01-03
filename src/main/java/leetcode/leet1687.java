package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class leet1687 {


/*    int[][] boxes;
    int portsCount;
    int maxBoxes;
    int maxWeight;
    Integer[] memo;

    public static void main(String[] args) {
        leet1687 l = new leet1687();
        l.boxDelivering(new int[][]{
                {1, 1}, {2, 1}, {1, 1}
        }, 2, 3, 3);
    }

    //TLE  记忆化搜索都会tle 啊啊啊
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        this.boxes = boxes;
        this.portsCount = portsCount;
        this.maxBoxes = maxBoxes;
        this.maxWeight = maxWeight;
        this.memo = new Integer[boxes.length];

        return helper(0);

    }

    int helper(int from) {
        if (from >= boxes.length) return 0;

        if (memo[from] != null) return memo[from];
        int sum = 0;
        int count = 0;
        int min = (int) 1e9;
        int pre = -1;
        int cost = 1;
        for (int i = from; i < boxes.length; i++) {
            int[] box = boxes[i];
            sum += box[1];
            count++;
            if (pre != box[0]) {
                cost++;
                pre = box[0];
            }
            if (sum <= maxWeight && count <= maxBoxes) {
                min = Math.min(min, helper(i + 1) + cost);
            } else {
                memo[from] = min;
                return min;
            }
        }
        return cost;
    }*/




  //改成平凡的dp也超时  看来是有什么优化方法啊
/*    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
    int []dp=new int[boxes.length];

    for(int from=boxes.length-1;from>=0;from--){
        int sum = 0;
        int count = 0;
        dp[from] = (int) 1e9;
        int pre = -1;
        int cost = 1;
        for (int i = from; i < boxes.length; i++) {
            int[] box = boxes[i];
            sum += box[1];
            count++;
            if (pre != box[0]) {
                cost++;
                pre = box[0];
            }
            if (sum <= maxWeight && count <= maxBoxes) {
                dp[from] = Math.min(dp[from], i+1>=boxes.length?cost: dp[i + 1] + cost);
            } else {
               break;
            }
        }



    }
   return dp[0];
    }*/



   //带思考的dp真的做不来
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
       int[] w=new int[boxes.length+1];
       int []neg=new int[boxes.length+1];

       w[1]=boxes[0][1];
       for (int i = 1; i < boxes.length; i++) {
            w[i+1]=w[i]+boxes[i][1];
            neg[i+1]=neg[i]+(boxes[i][0]==boxes[i-1][0]?0:1);
          // System.out.println(neg[i+1]);
       }

        int  []g=new int[boxes.length+1];
        int []f=new int[boxes.length+1];
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(0);
        for (int i = 1; i < boxes.length; i++) {
           while (!deque.isEmpty()&&(i-deque.peekFirst()>maxBoxes||(w[i]-w[deque.peekFirst()]>maxWeight))){
               deque.pollFirst();
           }

        f[i] =g[deque.peekFirst()]+neg[i]+2;

           if(i!=boxes.length) {
               g[i] = f[i] - neg[i + 1];
               while (!deque.isEmpty() && (g[i] < g[deque.peekLast()])) {
                   deque.pollLast();
               }
               deque.addLast(i);
           }
        }
     return f[boxes.length];
    }
}
