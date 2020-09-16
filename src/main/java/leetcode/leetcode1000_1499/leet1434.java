package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.List;

public class leet1434 {

    //把帽子和人反过来
    //状态压缩
    public int numberWays(List<List<Integer>> hats) {
      List<Integer>[]h2p=new List[41];
        for (int i = 0; i < h2p.length; i++) {
            h2p[i]=new ArrayList<>();
        }
        for (int i = 0; i < hats.size(); i++) {
            for (Integer integer : hats.get(i)) {
                h2p[integer].add(i); //帽子可以给第i个人
            }
        }
       Integer [][]dp=new Integer[41][1024];
   return dfs(h2p,dp,(1<<hats.size())-1,1,0);
    }

   int dfs(List<Integer>[]h2p,Integer[][]dp,int allMask,int hat,int assignedPeople)   {
      if(assignedPeople==allMask) return 1; //分配成功一个

      if(hat>40) return 0;//把分配不完的情况减去

      if(dp[hat][assignedPeople] != null) return dp[hat][assignedPeople];

      int ans=dfs(h2p,dp,allMask,hat+1,assignedPeople);

      for(int p:h2p[hat]){
          if(((assignedPeople>>p)&1)==1) continue;//已经分配了
        ans+=dfs(h2p,dp,allMask,hat+1,assignedPeople|(1<<p));
        ans%=1_000_000_007;

      }
      return dp[hat][assignedPeople]=ans;

   }

}
