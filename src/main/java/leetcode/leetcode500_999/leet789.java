package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/30.
 */
public class leet789 {
    public boolean escapeGhosts(int[][] ghosts, int[] t) {
        int d = Math.abs(t[0]) + Math.abs(t[1]);
        for (int[] g: ghosts)
            if (d >= Math.abs(t[0] - g[0]) + Math.abs(t[1] - g[1]))
                return false;
        return true;
    }
}
