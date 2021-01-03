package leetcode;

import java.util.Arrays;

public class leet1681 {



    //这算了 都没自己写的好
 /*   public int minimumIncompatibility(int[] nums, int k) {


        int len = 1 << nums.length;
        Integer dp[] = new Integer[len];
        int group = nums.length / k;//分成group个组


       Map<Integer,Integer> map=new HashMap<>();
        //算出所有可能的组数字
        for (int i = 1; i < len; i++) {
            if (Integer.bitCount(i) == group) {
                int hel = helper(i, nums);
                if (hel == -1) continue;//有重复数字
                map.put(i,hel);
                dp[i] = hel;
            }
        }


        for(int state=1;state<len;state++) {
            if (Integer.bitCount(state) % group != 0) continue; //剪枝

            //枚举子集
            for (int sub = state; sub > 0; sub = (sub - 1) & state) {
                if (dp[state ^ sub] != null && map.containsKey(sub)) {
                    if (dp[state] == null) {
                        dp[state] = dp[state ^ sub] + map.get(sub);
                    } else {
                        dp[state] = Math.min(dp[state], dp[state ^ sub] + map.get(sub));
                    }
                }
            }


        }

        return dp[len - 1] == null ? -1 : dp[len - 1];

    }

    int helper(int n, int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int index = 0;
        Set<Integer> set = new HashSet<>();
        //  boolean []set=new boolean[17];
        while (n > 0) {
            if ((n & 1) == 1) {
                if (set.contains(nums[index])) return -1;
                min = Math.min(min, nums[index]);
                max = Math.max(max, nums[index]);
                set.add(nums[index]);
            }
            index++;
            n >>= 1;
        }
        return max - min;
    }*/


  /*  public int minimumIncompatibility(int[] nums, int k) {


        int len = 1 << nums.length;
        Integer dp[][] = new Integer[k][len];
        int group = nums.length / k;//分成group个组


        List<int[]> list = new ArrayList<>();
        //算出所有可能的组数字
        for (int i = 1; i < len; i++) {
            if (Integer.bitCount(i) == group) {
                int hel = helper(i, nums);
                if (hel == -1) continue;//有重复数字
                list.add(new int[]{i, hel});
                dp[0][i] = hel;
            }
        }

        for (int i = 1; i < k; i++) {
            for (int j = 1; j < len; j++) {
                if (dp[i - 1][j] == null) continue;//剪枝
                for (int[] ints : list) {
                    if ((j & ints[0]) != 0) continue; //重复分组
                    int key = j | ints[0];
                    if (dp[i][key] == null) {
                        dp[i][key] = dp[i - 1][j] + ints[1];
                    } else {
                        dp[i][key] = Math.min(dp[i][key], dp[i - 1][j] + ints[1]);
                    }
                }
            }
        }

        return dp[k - 1][len - 1] == null ? -1 : dp[k - 1][len - 1];

    }

    int helper(int n, int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int index = 0;
        Set<Integer> set = new HashSet<>();
        //  boolean []set=new boolean[17];
        while (n > 0) {
            if ((n & 1) == 1) {
                if (set.contains(nums[index])) return -1;
                min = Math.min(min, nums[index]);
                max = Math.max(max, nums[index]);
                set.add(nums[index]);
            }
            index++;
            n >>= 1;
        }
        return max - min;
    }*/



    int[] nums;
    int[] memo;
    int INF = (int) 1e9;
    int group;
    int n;
    int k;
    //dfs+memo
    public int minimumIncompatibility(int[] nums, int k) {

        group = nums.length / k;
        n = nums.length;
        this.nums = nums;
        memo = new int[1 << n];
        this.k=k;
        if(group==1) return 0;
      int []cnt=new int[n+1];
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > k)
                return -1;
        }

        for (int i = 0; i < memo.length; i++) {
            memo[i]=-1;
        }

        Arrays.sort(nums);
      int res= dfs((1<<nums.length)-1);

      return res==INF?-1:res;
    }

    int dfs(int state) {

        if(memo[state]!=-1) return memo[state];

        if (Integer.bitCount(state) == group) { //结尾了
            int[] temp = new int[group];
            int index = 0;
            for (int i = 0; i < n; i++) {
                if ((state & (1 << i)) != 0) {
                    temp[index++] = i;
                }
            }

            for (int i = 1; i < temp.length; i++) {
                //存在重复数字
                if (nums[temp[i]] == nums[temp[i - 1]]) {
                    memo[state] = INF;
                    return INF;
                }
            }
            memo[state] = nums[temp[group - 1]] - nums[temp[0]];
            return memo[state];
        }



        int ans=INF;
        //求二进制子集  子集枚举 不能枚举子集哦
        for (int i = state& (state - 1); i > 0; i = (i - 1) & state) {
             if(Integer.bitCount(i)%group!=0) continue; //不能正好分组

         int left=dfs(i);

         if(left>=ans) continue; //剪枝

         int right=dfs(state^i);

         ans=Math.min(ans,left+right);
        }

        memo[state]=ans;
        return ans;

    }

    public static void main(String[] args) {
         leet1681 l=new leet1681();
         l.minimumIncompatibility(new int[]{1,2,1,4},2);
    }
}

