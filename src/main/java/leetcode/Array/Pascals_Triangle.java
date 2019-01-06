package leetcode.Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2017/10/11.
 */

public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new LinkedList<List<Integer>>();
        if (numRows > 0) triangle.add(Arrays.asList(1));
        for (int i = 2; i <= numRows; i++) {
            Integer[] a = new Integer[i];
            a[0] = 1;
            a[i - 1] = 1;
            List<Integer> b = triangle.get(i - 2);
            for (int j = 1; j < i - 1; j++) {
                a[j] = b.get(j) + b.get(j - 1);
            }
            triangle.add(Arrays.asList(a));
        }
        return triangle;
    }
}
