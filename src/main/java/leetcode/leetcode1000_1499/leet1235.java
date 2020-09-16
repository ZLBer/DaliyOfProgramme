package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1235 {

    //mine contest之后做出来了，时间不够啊啊啊
   /* public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int index = 0;
        int[][] job = new int[startTime.length][3];
        for (int i = 0; i < job.length; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }
        Arrays.sort(job, (a, b) -> a[1] - b[1]);
        *//*for (int i = 0; i < job.length; i++) {
            System.out.println(job[i][0]+"  "+job[i][1]+" "+job[i][2]);
        }*//*
        int[] dp = new int[job[job.length - 1][1] + 1];
        for (int i = 1; i < dp.length; i++) {
            if (job[index][1] > i) {
                //没有任何工作适合
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = Math.max(dp[job[index][0]] + job[index++][2], dp[i - 1]);
            while (index < job.length && job[index][1] == job[index - 1][1]) {
                System.out.println("test");
                int temp = Math.max(dp[job[index][0]] + job[index][2], dp[i - 1]);
                dp[i] = Math.max(dp[i], temp);
                index++;
            }
        }
       *//* for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }*//*
        return dp[job[job.length - 1][1]];
    }*/


    //你会发现比你的想法好多了  TreeMap
    //不需要遍历所有的时间哦 ，只需要遍历所有的工作
   /* public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            //取比开始时间小的第一个
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            //和最后一个比较 ，若收益大则入
            if (cur > dp.lastEntry().getValue())
                dp.put(job[1], cur);
        }
        return dp.lastEntry().getValue();
    }*/



   //  用List
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // sort by endTime
        int[][] items = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            items[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(items, (a1, a2)->a1[1] - a2[1]);
        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        // init value to avoid IndexOutBoundExp
        dpEndTime.add(0);
        dpProfit.add(0);
        for (int[] item : items) {
            int s = item[0], e = item[1], p = item[2];
            // find previous endTime index
            //   如果搜索键包含在列表中，则返回搜索键的索引；否则返回 (-(插入点) - 1)
            int prevIdx = Collections.binarySearch(dpEndTime, s + 1);
            //求前一个  开始时间S
            if (prevIdx < 0) {
                prevIdx = -prevIdx - 1;
            }
            prevIdx--;
            //计算之前和最后
            int currProfit = dpProfit.get(prevIdx) + p, maxProfit = dpProfit.get(dpProfit.size() - 1);
            if (currProfit > maxProfit) {
                dpProfit.add(currProfit);
                dpEndTime.add(e);
            }
        }
        return dpProfit.get(dpProfit.size() - 1);
    }



   //数组
  /*  public int jobScheduling(int[] st, int[] et, int[] profit) {
        int n = profit.length;
        Job[] jobs = new Job[n];
        for(int i = 0; i < n; i++)
            jobs[i] = new Job(st[i], et[i], profit[i]);
        Arrays.sort(jobs, (a,b) -> (a.end - b.end));

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(jobs[i].profit,dp[i-1]);
            for(int j = i-1; j >= 0; j--){
                if(jobs[j].end <= jobs[i].start){
                    dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
                    break;
                }
            }
        }
        return dp[n-1];
    }*/

    class Job {
        int start, end, profit;
        public Job(int s, int e, int p){
            start = s;
            end = e;
            profit = p;
        }
    }
}
