package leetcode;

public class leet1578 {
    public int minCost(String s, int[] cost) {
    int  res=0;
      char  pre=s.charAt(0);
      int preCost=cost[0];
    for (int i = 1; i < cost.length; i++) {
        char  c=s.charAt(i);
        int curCost=cost[i];
     if(c==pre) {
       if(preCost>curCost){
         res+=curCost;
       }else {
        res+=preCost;
        preCost=curCost;
       }
     }else {
       pre=s.charAt(i);
       preCost=cost[i];
     }
        }
    return res;
    }
}
