package leetcode;

import java.util.Arrays;

public class leet1626$ {

    ///dfs超时了
/*    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] tump = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            tump[i][0] = ages[i];
            tump[i][1] = scores[i];
        }
        Arrays.sort(tump, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);


        helper(tump,tump[0][0],0,Integer.MAX_VALUE,0);
        return res;
    }
    int res=0;
    void  helper(int [][]tump,int age,int index,int min,int sum){
        if(index>=tump.length){
            res=Math.max(res,sum);
            return;
        }

        while (index<tump.length&&tump[index][0]==age+1){
            index++;
        }

        while (index<tump.length&&tump[index][0]!=age){
            age--;
        }

        //不选这个年龄
        helper(tump,age-1,index+1,min,sum);
        //选这个年龄
        for(int i=index;i<tump.length;i++){
            if(tump[i][0]!=age||tump[i][1]>min) continue;
            sum+=tump[i][1];
            helper(tump,age,i+1,tump[i][1],sum);

        }
    }*/


    public int bestTeamScore(int[] scores, int[] ages) {
    int []dp=new int[scores.length];
        int[][] tump = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            tump[i][0] = ages[i];
            tump[i][1] = scores[i];
        }
        Arrays.sort(tump, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < tump.length; i++) {
           dp[i]=tump[i][1];
            for (int j = 0; j < i; j++) {
            if(tump[j][1]<=tump[i][1])
            dp[i]=Math.max(dp[i],dp[j]+tump[i][1]);
            }        
        }
       return dp[dp.length-1];
    }



    public static void main(String[] args) {
       // bestTeamScore(new int[]{4,5,6,5},new int[]{2,1,2,1});
    }
}
