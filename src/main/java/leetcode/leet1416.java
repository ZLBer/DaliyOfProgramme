package leetcode;

public class leet1416 {

    //mine
  public int numberOfArrays(String s, int k) {
dp=new Integer[s.length()+1];
 return  dfs(s,0,k);
    }

    Integer []dp;
   int mod=1000000007;
     int dfs(String s,int start,int k){
         int end=s.length();
     if(start==end) return 1;

        if(start+1==end){
            if(s.charAt(start)!='0'&&s.charAt(start)-'0'<=k)
            return 1;
            else return -1;
        }



        if(dp[start]!=null) return dp[start];

        long res=0;
        for(int i=start;i<end;i++){

            String left=s.substring(start,i+1);

            if(left.startsWith("0")||left.length()>10||Long.parseLong(left)>k) break;


             int right=dfs(s,i+1,k);

             if(right!=-1) res+=right;
             res%=mod;
        }
        dp[start]=(int)res;
        return (int)res;
    }


    //bottom-up dp
 /*   public int numberOfArrays(String s, int k) {
    int [] dp=new int[s.length()+1];
    dp[s.length()]=1;
    for(int i=s.length()-1;i>=0;i--){
        if(s.charAt(i)=='0') continue;

        long temp=0;
        for(int j=i+1;j<=s.length();j++){
            temp=temp*10+s.charAt(j-1)-'0';

            if(temp>k) break;
            dp[i]=(dp[i]+dp[j])%1000000007;
        }
    }
    return dp[0];
    }
*/
}
