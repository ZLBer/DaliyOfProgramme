package leetcode;

public class leet845 {
    //mine
/*    public int longestMountain(int[] A) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
         if(A[i]>A[i-1]&&A[i]>A[i+1]) list.add(i);
         }
        for (Integer index : list) {
         int temp=1;
         int point=index;
         while (point>0&&A[point]>A[point-1]){
             point--;
             temp++;
         }
         point=index;
        while (point<A.length&&A[point]>A[point+1]){
            point++;
            temp++;
        }
       res=Math.max(res,temp);
        } 
       return res;
    }*/
    //也是两次遍历
    public int longestMountain(int[] A) {
        int N = A.length, res = 0;
        int[] up = new int[N], down = new int[N];
        for (int i = N - 2; i >= 0; --i) if (A[i] > A[i + 1]) down[i] = down[i + 1] + 1;
        for (int i = 0; i < N; ++i) {
            if (i > 0 && A[i] > A[i - 1]) up[i] = up[i - 1] + 1;
            if (up[i] > 0 && down[i] > 0) res = Math.max(res, up[i] + down[i] + 1);
        }
        return res;
    }


    //one pass
/*    public int longestMountain(int[] A) {
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; ++i) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) up = down = 0; //重置
            if (A[i - 1] < A[i]) up++;
            if (A[i - 1] > A[i]) down++;
            if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1; //每个下降点都要计算
        }
        return res;
    }*/
}
