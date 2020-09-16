package leetcode.leetcode1000_1499;

import java.util.Arrays;

public class leet1449 {


    //自己写的dp  可以过
    //可以理解成完全背包  只是比较那里要重新写罢了
/*
    public String largestNumber(int[] cost, int target) {
     String []dp=new String[target+1];
   dp[0]="";
        for (int i = 1; i < dp.length; i++) {
            for(int c=0;c<cost.length;c++){
               int preTarget=i-cost[c];
               if(preTarget<0||dp[preTarget]==null) continue;
               // System.out.println(i+"  "+c+" "+dp[preTarget]);
               dp[i]=helper(dp[i],dp[preTarget]+(c+1));
            }
        }
        return dp[target]==null?"0":dp[target];
    }

    String helper(String a,String b){
        if(a==null) return b;
      if(a.length()>b.length()){
          return a;
      }else if(b.length()>a.length()){
          return b;
      }else {
          for (int i = 0; i < a.length(); i++) {
             char ca=a.charAt(i);
             char cb=b.charAt(i);
              if(ca>cb){
               return a;
             }else if(cb>ca){
                  return b;
              }
          }
      }
      return a;
    }
*/


    //从上往下  省去了很多不必要的比较
    //相当于从后往前算
    //而我上面的是从前往后看  所以不好比较
  /*  public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        return dfs(cost, target, dp);
    }
    String dfs(int[] cost, int target, String[] dp) {
        if (target < 0) return "0"; // not found
        if (target == 0) return "";
        if (dp[target] != null) return dp[target];
        String ans = "0";
        for(int d = 9; d >= 1; d--) {
            String curr = dfs(cost, target - cost[d - 1], dp);
            if (curr.equals("0")) continue; // skip if can't solve sub-problem
            curr = d + curr;
            if (ans.equals("0") || curr.length() > ans.length()) {
                ans = curr;
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append("12345");
        return dp[target] = ans;
    }*/


  //跟踪数组   这想法太秀了
  /*  public String largestNumber(int[] cost, int target) {
        Integer[] dp = new Integer[target + 1];
        Integer[] trace = new Integer[target + 1];
        int ans = dfs(cost, target, dp, trace);
        if (ans <= 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (target > 0) { // trace back to get the result
            sb.append(trace[target]);
            target -= cost[trace[target] - 1];
        }
        return sb.toString();
    }
    int dfs(int[] cost, int target, Integer[] dp, Integer[] trace) {
        if (target < 0) return -1; // not found
        if (target == 0) return 0;
        if (dp[target] != null) return dp[target];
        int ans = -1;
        for(int d = 9; d >= 1; d--) {
            int curr = dfs(cost, target - cost[d - 1], dp, trace);
            if (curr == -1) continue; // skip if can't solve sub-problem
            if (curr + 1 > ans) {
                ans = curr + 1;
                trace[target] = d;
            }
        }
        return dp[target] = ans;
    }
*/

  //从后向前遍历
  public String largestNumber(int[] cost, int target) {
      String[]dp=new  String[target+1];
      Arrays.fill(dp,"0");
      dp[target] = "";
      for (int i = target- 1; i >= 0; --i) {
          for (int n = 9; n >0; n--) {
              int val = i + cost[n - 1];
              if (val <= target && dp[val] != "0")
                  if (dp[i]=="0"||dp[val].length() + 1 > dp[i].length()) //注意这里
                      dp[i] = n + dp[val];
          }
      }
      for (String s : dp) {
          System.out.println(s);
      }
      return dp[0];
  }


  //试图修改自己的第一版本
 /*   public String largestNumber(int[] cost, int target) {
        String []dp=new String[target+1];
        dp[0]="";
        for (int i = 1; i < dp.length; i++) {
            for(int c=cost.length-1;c>=0;c--){
                int preTarget=i-cost[c];
                if(preTarget<0||dp[preTarget]==null) continue;
                // System.out.println(i+"  "+c+" "+dp[preTarget]);
                dp[i]=(dp[i]==null||dp[i].length()<(dp[preTarget].length()+1))?(c+1)+dp[preTarget]:dp[i];
            }
        }
        for (String s : dp) {
            System.out.println(s);
        }
        return dp[target]==null?"0":dp[target];
    }*/

}
