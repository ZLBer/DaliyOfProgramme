package leetcode;

public class leet1444 {
    static   public int ways(String[] pizza, int k) {
        Integer [][][]dp=new Integer[pizza.length+1][pizza[0].length()+1][k];
        if(k==1) return dfs(dp,pizza,0,0,k-1);
        dfs(dp,pizza,0,0,k-1);

        return dp[0][0][k-1];
    }
    static int mod=1000000007;
    static    int dfs(Integer[][][]dp,String[]pizza,int row,int col,int k){
        if(row>=pizza.length||col>=pizza[0].length()) return 0;
        if(k==0) {
            if (check(pizza, row, pizza.length, col, pizza[0].length())) {
                return 1;
            } else { //没有苹果了
                return 0;
            }
        }


        if(dp[row][col][k]!=null) return dp[row][col][k];

        long count=0;
        for(int i=row+1;i<pizza.length;i++){ //横着切
            if(check(pizza,row,i,col,pizza[0].length())){
                count+=dfs(dp,pizza,i,col,k-1)%mod;
            }
        }

        for(int i=col+1;i<pizza[0].length();i++){
            if(check(pizza,row,pizza.length,col,i)){
                count+=dfs(dp,pizza,row,i,k-1)%mod;
            }
        }

        dp[row][col][k]=(int)(count%mod);
        return (int)(count%mod);

    }
    static boolean check(String[]pizza,int fromRow,int row,int fromCol,int col){
        for(int i=fromRow;i<row;i++){
            for(int j=fromCol;j<col;j++){
                if(pizza[i].charAt(j)=='A') return true;
            }
        }
        return false;
    }

}
