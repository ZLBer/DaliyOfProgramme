package leetcode.leetcode500_999;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by libin on 2019/1/13.
 */
public class leet973 {
/*    static public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        int distance[][] = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            distance[i][0] = i;
            distance[i][1] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }
        Arrays.sort(distance,new MyComprator());
       for(int i=0;i<K;i++){
           result[i]=points[distance[i][0]];
       }
        return result;
    }

    static class MyComprator implements Comparator<int[]> {

        public int compare(int[] arg0, int[] arg1) {


            if (arg0[1] >= arg1[1])
                return 1;
            else
                return -1;
        }
    }*/

    public static void main(String[] args) {

    }



    Random rand = new Random();

    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        random_select(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void random_select(int[][] points, int left, int right, int K) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1) {
            random_select(points, left, i - 1, K);
        } else if (K > i - left + 1) {
            random_select(points, i + 1, right, K - (i - left + 1));
        }
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }


}

