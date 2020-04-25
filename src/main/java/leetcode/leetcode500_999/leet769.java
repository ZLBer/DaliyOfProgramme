package leetcode.leetcode500_999;

public class leet769 {
    //mine  秒做..
    public int maxChunksToSorted(int[] arr) {
        int max=Integer.MIN_VALUE;
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
            if(i==max) {
                count++;
                max=Integer.MIN_VALUE;
            }

        }
        return count;
    }
}
