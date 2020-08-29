package leetcode;

public class leet1562 {
 /*   public int findLatestStep(int[] arr, int m) {
        TreeSet<Integer> set=new TreeSet<>();
        set.add(0);
        set.add(arr.length+1);
        if(m==arr.length) return arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            int div=arr[i];
          int low=set.floor(div);
          int hight=set.ceiling(div);
          int left=(div-low-1);
          int right=(hight-div-1);

          if(left==m||right==m) return i;

          set.add(div);

        }

        return -1;
    }*/


    //线性写法
    public int findLatestStep(int[] A, int m) {
        int res = -1, n = A.length;
        int[] length = new int[n + 2], count = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int a = A[i], left = length[a - 1], right = length[a + 1];
            int next=left + right + 1;
            length[a - left] = length[a + right] = next;//只更新边界即可
            count[left]--;
            count[right]--;
            count[next]++;
            if (count[m] > 0)
                res = i + 1;
        }
        return res;
    }
}
