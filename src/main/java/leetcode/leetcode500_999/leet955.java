package leetcode.leetcode500_999;

public class leet955 {
    //贪心法
    static  public int minDeletionSize(String[] A) {
        int res = 0, n = A.length, m = A[0].length(), i, j;
        //sort表示之前是否是有序的
        boolean[] sorted = new boolean[n - 1];
        for (j = 0; j < m; ++j) {
            for (i = 0; i < n - 1; ++i) {
                //若之前有序，则直接跳过
                //若之前无序，则比较该处与之后 ：若之后大于之前，则需要删除这一列
                if (!sorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
                    res++;
                    break;
                }
            }
            //表示这一列删除了
            if (i < n - 1) continue;
            //表示此列未删除，需要更新最新的排序状态
            for (i = 0; i < n - 1; ++i)
                if (A[i].charAt(j) < A[i + 1].charAt(j))
                    sorted[i] = true;
        }
        return res;
    }

    public static void main(String[] args) {
        minDeletionSize(new String[]{"xgab","xfaa","yfaa"});
    }
}
