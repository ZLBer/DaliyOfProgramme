package leetcode;

public class LCP25 {
    //TLE
 /*   public int keyboard(int k, int n) {

        for (int i = 0; i < n; i++) {
          map.put(i,new HashMap<>());
        }
      return   (int)helper(0,n,new int[26],k);

    }
    int mod=1000000007;
  Map<Integer, Map<String,Integer>> map=new HashMap<>();
    long helper(int index,int n,int []count,int k){
       if(index>=n){
         return 1;
       }

       String key=toString(count);
    if(map.get(index).containsKey(key)) return map.get(index).get(key);

    long sum=0;
        for (int i = 0; i < count.length; i++) {
          if(count[i]<k){
              count[i]++;
           sum=(sum+ helper(index+1,n,count,k))%mod ;
            count[i]--;
          }
        }
    map.get(index).put(key,(int)sum);
        return sum;
    }

    String toString(int []cout){
      StringBuilder sb=new StringBuilder();
        for (int i = 0; i < cout.length; i++) {
            sb.append(cout[i]);
        }
        return sb.toString();
    }*/



 // dfs+memo
/*    Map<Integer, Long> maps = new HashMap<>();

    public int keyboard(int k, int n) {
        int[] dp = new int[k + 1];
        dp[k] = 26;
        return (int) (dfs(dp, n, k) % 1000000007);
    }


    private long dfs(int[] map, int n, int limit) {
        int state = getState(map);
        if (!maps.containsKey(state)) {
            long res = 0;
            if (n == 1) {
                //存在用光的情况 所以每次都要计算
                for (int i = 1; i <= limit; i++) {
                    res += map[i];

                }
            } else {
                //以k作为维度
                for (int i = 1; i <= limit; i++) {
                    if (map[i] != 0) {
                        map[i]--;
                        map[i - 1]++;

                        res += (map[i] + 1) * dfs(map, n - 1, limit);
                        res %= 1000000007;

                        // 回溯
                        map[i]++;
                        map[i - 1]--;
                    }
                }
            }
            maps.put(state, res);
            return res;
        }
        return maps.get(state);
    }

    public int getState(int[] map) {
        int cur = 0;
        for (int i = 1; i < map.length; i++) {
            cur *= 27;
            cur += map[i];
        }
        return cur;
    }*/


    //dp 类似多重背包
    static   public int keyboard(int k, int n) {
        long [][]dp=new long[27][n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=1; //n为0只可能有一种情况
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                for(int x=0;x<=k;x++){
                    if(x>j) break;
                    dp[i][j]+=dp[i-1][j-x]*combination(j,x);
                    dp[i][j]%=1000000007;
                }

            }

        }
//        for (long[] longs : dp) {
//            System.out.println(Arrays.toString(longs));
//        }
        return (int)dp[dp.length-1][dp[0].length-1];
    }

    //组合数 Cnm   m>n
    static long combination(int m, int n) {
        int k=1;
        long ans=1;
        while (k<=n){
            ans=((m-k+1)*ans)/k;
            k++;
        }
        return ans;

    }

    public static void main(String[] args) {
        keyboard(1,2);
    }

}
