package leetcode.leetcode500_999;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by libin on 2019/1/13.
 */
public class leet973 {
    static public int[][] kClosest(int[][] points, int K) {
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
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {0, 1},
                {1, 4},
                {2, 2}
        };
        Arrays.sort(test,new MyComprator());
        for (int i[] : test) {
            System.out.print(i[0]);
            System.out.println(i[1]);
        }


    }
}

