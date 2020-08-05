package leetcode;

public class leet1521 {
    //这不就是直接暴力吗
    public int closestToTarget(int[] arr, int t) {
        int m = arr.length, res = Integer.MAX_VALUE;
        int prev = 0;
        for (int i = 0; i < m; i++) {
            int sum = arr[i];
            for (int r = i; r < m; r++) {
                sum = sum & arr[r];
                res = Math.min(res, Math.abs(sum - t));
                if (res == 0) return res;  // best is 0;
                if (sum <= t) break;   // sum is decreasing within inner loop. and now sum < t, res won't be lower.
            }
            if (sum > t) break; // the future sum won't be smaller than this sum, so res won't be smaller
            //current sum = arr[i] & ... & arr[n -1], which is the smallest, any further sum after this loop,
            // which will be arr[k] & ... & arr[n -1], where k > i, will be larger than current sum;
        }
        return res;
    }

    //set去重 排除一些情况，因为int就32位
/*    public int closestToTarget(int[] arr, int t) {
        int m = arr.length, res = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> tmp = new HashSet<>();
            tmp.add(arr[i]);
            for (int n : set) {
                int te=n & arr[i];

                res = Math.min(res, Math.abs(te - t));
               if(te<t) continue;
                tmp.add(te);
            }
            set = tmp;
        }
        return res;
    }*/
}
