package leetcode.leetcode1000_;

public class leet1349$ {
    //mine dfs  TLE  50/55
/*   public int maxStudents(char[][] seats) {

        return dfs(seats,0,0);
    }
    int dfs(char [][]seats,int x,int y){
     if(x>=seats.length) return 0;
     if(y>=seats[0].length) {
         return dfs(seats,x+1,0);
     }
     int res=0;
     //没有座位继续下一个
     res=Math.maxSum(res, dfs(seats,x,y+1));
     //有座位 判断
        if(seats[x][y]=='.'&&check(seats,x,y)) {
            seats[x][y]='P';
            res=Math.maxSum(res,dfs(seats,x,y+1)+1);
            seats[x][y]='.';
        }
        return res;

    }

    boolean check(char[][]seats,int x,int y){
     if(y-1>=0&&seats[x][y-1]=='P') return false;
     if(x-1>=0&&y-1>=0&&seats[x-1][y-1]=='P') return false;
     if(x-1>=0&&y+1<seats[0].length&&seats[x-1][y+1]=='P') return false;
     if(y+1<seats[0].length&&seats[x][y+1]=='P') return false;
     return true;
    } */



   //   状态压缩DP  这我绝对做不出来..
/*   static public int maxStudents(char[][] seats) {
        int n = seats.length, m = seats[0].length;
        int[][] dp = new int[n + 1][1 << m];
        for(int i = n - 1; i >= 0; i--){
            for(int preMask = 0; preMask < (1 << m); preMask++){
                int res = 0;
                for(int curMask = 0; curMask < (1 << m); curMask++){
                    if(isValid(curMask, preMask, seats, i)){
                        res = Math.maxSum(res, Integer.bitCount(curMask) + dp[i + 1][curMask]);
                    }
                }
                dp[i][preMask] = res;
            }
        }
        return dp[0][0];
    }*/

  static   private boolean isValid(int mask, int preMask, char[][] seats, int r) {
        int m = seats[0].length;
        for (int i = 0; i < m; i++) {
            if ((mask & (1 << i)) == 0) { //表示此位置没有人
                continue;
            }
            //已经判断这个位置有人
            if (seats[r][i] == '#') {   //表示此位置没有座位
                return false;  //没有座位要返回false
            }
            if (i > 0 && seats[r][i - 1] == '.' && (mask & (1 << (i - 1))) != 0) { //判断左边
                return false;
            }
            if (i < m - 1 && seats[r][i + 1] == '.' && (mask & (1 << (i + 1))) != 0) {//判断右边
                return false;
            }
            if (r > 0 && i > 0 && seats[r - 1][i - 1] == '.' && (preMask & (1 << (i - 1))) != 0) { //判断左上
                return false;
            }
            if (r > 0 && i < m - 1 && seats[r - 1][i + 1] == '.' && (preMask & (1 << (i + 1))) != 0) { //判断右上
                return false;
            }
        }
        return true;
    }
    //  记忆化dfs
    public int maxStudents(char[][] seats) {
        int n = seats.length, m = seats[0].length;
        Integer[][] memo = new Integer[n][1 << m];
        return dfs(seats, memo, 0, 0);
    }

    //以行为遍历对象
    private int dfs(char[][] seats, Integer[][] memo, int r, int preMask){
        int n = seats.length, m = seats[0].length;
        if(r == n){
            return 0;
        }
        if(memo[r][preMask] != null){   //记录返回
            return memo[r][preMask];
        }
        int res = 0;
        for(int i = 0 ; i < (1 << m) ;i++){   //一个一个遍历
            if(isValid(i, preMask, seats, r)){
                res = Math.max(res, Integer.bitCount(i) + dfs(seats, memo, r + 1, i));
            }
        }
        memo[r][preMask] = res;
        return res;
    }


    public static void main(String[] args) {
     /* maxStudents(new char[][]{
                {'#','.','#','#','.','#'},{'.','#','#','#','#','.'},{'#','.','#','#','.','#'}
        }); */
    }

}
