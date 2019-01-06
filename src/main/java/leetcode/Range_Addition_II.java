package leetcode;

/**
 * Created by libin on 2017/10/8.
 */
public class Range_Addition_II {
    public int maxCount(int m, int n, int[][] ops) {
        int a=m;
        int b=n;
        for (int i = 0; i < ops.length; i++) {
            if(a>ops[i][0]) a=ops[i][0];
            if(b>ops[i][1])  b=ops[i][1];
        }
        return a*b;
    }

    }

