package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leet1240$ {
//DFS+memo  也有种DP的味道
//https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/discuss/414260/8ms-Memorized-Backtrack-Solution-without-special-case!

    Map<Long, Integer> set = new HashMap<>();
    int res = Integer.MAX_VALUE;
    public int tilingRectangle(int n, int m) {
        if (n == m) return 1;
        //让m始终大于n
        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
        }
        dfs(n, m, new int[n + 1], 0);
        return res;
    }
    private void dfs(int n, int m, int[] h, int cnt) {
        //剪枝  比之前记录的结果还大
        if (cnt >= res) return;
        //铺满的标志
        boolean isFull = true;
        int pos = -1, minH = Integer.MAX_VALUE;
        //求最小的高度以及判断是否铺满
        for (int i = 1; i <= n; i++) {
            if (h[i] < m) isFull = false;
            if (h[i] < minH) {
                pos = i;
                minH = h[i];
            }
        }
        //铺满就返回
        if (isFull) {
            res = Math.min(cnt, res);
            return;
        }

        //为了生成一个这个状态的key来记录cnt
        long key = 0, base = m + 1;
        for (int i = 1; i <= n; i++) {
            key += h[i] * base;
            base *= m + 1;
        }
        //如果之前有这个状态而且更小，就返回不用继续了
        if (set.containsKey(key) && set.get(key) <= cnt) return;
        set.put(key, cnt);

        //pos表示minH的位置
        int end = pos;
        //求一个正方形
        while (end + 1 <= n && h[end + 1] == h[pos] && (end + 1 - pos + 1 + minH) <= m) end++;

        //从最大可能的正方形到最下的开始遍历
        for (int j = end; j >= pos; j--) {
            int curH = j - pos + 1;

            int[] next  = Arrays.copyOf(h, n + 1);
            for (int k = pos; k <= j; k++) {
                next[k] += curH;
            }
              //继续下一趟搜索
            dfs(n, m, next, cnt + 1);
        }

    }










  //另一种DFS  没个单位用一个boolea表示
    //从这一行开始一列一列遍历，这一行完事了就去下一行
/*    int ans = Integer.MAX_VALUE;
    public int tilingRectangle(int n, int m) {
        dfs(0, 0, new boolean[n][m], 0);
        return ans;
    }
    // (r, c) is the starting point for selecting a square
    // rect records the status of current rectangle
    // cnt is the number of squares we have covered
    private void dfs(int r, int c, boolean[][] rect, int cnt) {
        int n = rect.length, m = rect[0].length;
        // optimization 1: The current cnt >= the current answer
        //剪枝
        if (cnt >= ans) return;

        // Successfully cover the whole rectangle
        //已经全部铺满
        if (r >= n) {
            ans = cnt;
            return;
        }

        //去下一行
        // Successfully cover the area [0, ..., n][0, ..., c] => Move to next row
        if (c >= m) {
            dfs(r+1, 0, rect, cnt);
            return;
        }


        //取下一列
        // If (r, c) is already covered => move to next point (r, c+1)
        if (rect[r][c]) {
            dfs(r, c+1, rect, cnt);
            return;
        }

        // Try all the possible size of squares starting from (r, c)
        for (int k = Math.min(n-r, m-c); k >= 1 && isAvailable(rect, r, c, k); k--) {
            cover(rect, r, c, k);
            dfs(r, c+1, rect, cnt+1);
            uncover(rect, r, c, k);
        }
    }
    // Check if the area [r, ..., r+k][c, ..., c+k] is alreadc covered
    private boolean isAvailable(boolean[][] rect, int r, int c, int k) {
        for (int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                if(rect[r+i][c+j]) return false;
            }
        }
        return true;
    }
    // Cover the area [r, ..., r+k][c, ..., c+k] with a k * k square
    private void cover(boolean[][] rect, int r, int c, int k) {
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                rect[r+i][c+j] = true;
            }
        }
    }
    // Uncover the area [r, ..., r+k][c, ..., c+k]
    private void uncover(boolean[][] rect, int r, int c, int k) {
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                rect[r+i][c+j] = false;
            }
        }
    }*/
}
